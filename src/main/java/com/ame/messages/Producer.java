package com.ame.messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import com.ame.messages.incoming.MessagesPublisher;
import com.ame.messages.model.Message;
import static com.ame.messages.utils.ConvertStringToTimestamp.convertS2T;

@SpringBootApplication
/**
 * Main class for injecting event messages into a Kafka topic
 * 
 * @author Antoine Meheut
 * 
 */
public class Producer {

	@Autowired
	private MessagesPublisher messagesPublisher;

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Producer.class).web(false).run(args);
        try {
		    context.getBean(Producer.class).run(context);
		    context.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private void run(ConfigurableApplicationContext context) throws Exception {

		System.out.println("Start sending alert messages to Kafka ...");

		MessageChannel producerChannel = context.getBean("producerChannel", MessageChannel.class);

		try {
            List<Message> messages = messagesPublisher.getMessageslus();

            int i = 0;
            while (! messages.isEmpty()) {
                try {
                    LocalTime heureTus = convertS2T(messages.get(i).getMsgH());
                    SimpleDateFormat heureFormater = new SimpleDateFormat ("HH:mm");
                    Date currentTime = new Date();
                    LocalTime heureSysteme = convertS2T(heureFormater.format(currentTime));
                    if (heureTus.equals(heureSysteme)) {
                        System.out.println("Send message [CTIT = " + messages.get(i).getCtit() + ", " +
                                "to topic = " + messages.get(i).getTopic() + ", " +
                                "system time = " + heureSysteme.toString() + ", " +
                                "Number of messages remaining = " + String.valueOf(messages.size() - 1) + ", " +
                                "time CSV = " + messages.get(i).getMsgH() + "]");
                        Map<String, Object> headers = Collections.singletonMap(KafkaHeaders.TOPIC, messages.get(i).getTopic());
                        producerChannel.send(new GenericMessage<>(messages.get(i).toString(), headers));
                        messages.remove(i);
                    } else {
                        if (i < (messages.size() - 1)) {
                            i += 1;
                        } else {
                            i = 0;
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("End of sending alert messages to Kafka ...");
	}
}
