package com.ame.messages.incoming;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.ame.messages.model.Message;
import static com.ame.messages.utils.LectureCsv.parseLine;

@Component
@Configuration
/**
 * Class allowing to create as many messages as desired before injection into Kafka
 * 
 * @author Antoine Meheut
 * 
 */
public class MessagesPublisher {
	/**
	 * Variable found in application.properties: path and name of CSV file
	 */
	@Value("${spring.kafka.CSVfile}")
	private String CSVfile;

	/**
	* Method that reads a CSV file and makes the list of messages to inject
	*/
	public List<Message> getMessageslus() throws Exception {
        List<Message> messages = new ArrayList<Message>();

		String csvFile = CSVfile;

		Scanner scanner = new Scanner(new File(csvFile));
		while (scanner.hasNext()) {
			List<String> line = parseLine(scanner.nextLine());
            messages.add(createMessage(line.get(0), line.get(1), line.get(2), line.get(3),
                    line.get(4), line.get(5), line.get(6), line.get(7), line.get(8)));
		}
		scanner.close();

		return messages;
	}

	/**
	* Generic method that creates messages
	*
	* @param msgID
	*           Message type identification ID, example: "EVT" for event
	* @param msgTS
	*           Flow emission timestamp, example: "2017-03-26-18.17.37.049316"
	* @param ddate
	*			Summarized date of an event, example: "2018-02-27"
	* @param nuoff
	*			Official number, example: 130
	* @param nucycle
	*           Cycle number, example: 234156
	* @param nucycleg
	*			General cycle number, example: 1
	* @param ctit
	*           Type of intervention code, example: "110"
	*
	*/
	Message createMessage( String msgID, String msgTS, String ddate, String nuoff, String nucycle, String nucycleg, String ctit, String msgH, String topic) {
		Message message = new Message();

		message.setMsgID(msgID);
		message.setMsgTS(msgTS);
		message.setDdate(ddate);
		message.setNuoff(nuoff);
		message.setNucycle(nucycle);
		message.setNucycleg(nucycleg);
		message.setCtit(ctit);
		message.setMsgH(msgH);
		message.setTopic(topic);

		return message;
	}
}
