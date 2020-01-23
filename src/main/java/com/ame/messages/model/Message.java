package com.ame.messages.model;

import lombok.*;

@Data
@NoArgsConstructor

/**
 * Class used to configure the structure of messages to be injected
 * 
 * @author Antoine Meheut
 * 
 */
public class Message {
	/**
	 * msgID : Message type identification ID, example: "EVT" for event
	 */
	private String msgID;

	/**
	 * msgTS : Flow emission timestamp, example: "2017-03-26-18.17.37.049316"
	 */
	private String msgTS;

	/**
	 * ddate : Summarized date of an event, example: "2018-02-27"
	 */
	private String ddate;

	/**
	 * nuoff : Official number, example: 130
	 */
	private String nuoff;

	/**
	 * nucycle : Cycle number, example: 234156
	 */
	private String nucycle;

	/**
	 * nucycleg : General cycle number, example: 1
	 */
	private String nucycleg;

	/**
	 * ctit : Type of intervention code, example: "110"
	 */
	private String ctit;

	/**
	 * msgH : Timestamp of transmission of the stream with only the time, example: "18.17.37.049316"
	 */
	private String msgH;

	/**
	 * topic : Indicates the name of the topic to which we want to inject the messages, example: "AME_AME.IN"
	 */
	private String topic;

}
