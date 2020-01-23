What is that
============
POC produced to check the technical feasibility of writing in a
topic Kafka of events from a java application

This project is the part that injects events into a Kafka topic.
This code can be used as a stopper to inject events.

The framework is based on
=========================
- springframework.boot: to save time and quickly create a
application executable on a ReadHat VM
- org.apache.kafka: which allows to open the connection with the Kafka machine,
to connect to topic and write events there
- springframework.kafka: which saves time for everything
concerns the use of Kafka in a Spring project in Java


The components of this project are
==================================
- a src/main/resources/application.properties file which contains the address of the Kafka machine
- the src/main/java/com/ame/messages/Producer.java class: main class which contains a run method for executing writes in the Kafka
- src/main/java/com/ame/messages/model/Message.java: class that defines the structure of messages sent to Kafka
	* msgID: Identification ID of the message type, example: "EVT" for event
	* msgTS: Timestamp of transmission of the stream, example: "2017-03-26-18.17.37.049316"
	* date: Summarized date of an event, example: "2018-02-27"
	* nuoff: Official number, example: 130
	* nucycle: Cycle number, example: 234156
	* nucycleg: General cycle number, example: 1
	* ctit: Type of intervention code, example: "110"
	* msgH: Timestamp of transmission of the stream with only the time, example: "18.17.37.049316"
	* topic: Indicates the name of the topic to which one wishes to inject the messages, example: "AME_AME.IN"
- src/main/java/com/ame/messages/incoming/MessagesPublisher.java: class which
 creates the messages that will be sent to Kafka.
- src/main/java/com/ame/messages/config/ProducerChannelConfig.java: class who makes the connection to Kafka. There is no topic creation, because they are instantiated on the fly by sending messages
 
The project opens on Eclipse or IntelliJ.
 
To build for the first time
===========================

`mvn clean install -U`

To execute the project, two possibilities
=========================================
Method 1
--------
- Copy the sources on a RHEL, place in the directory
where is the pom of the project namely kafka_producer and type the command:

`mvn clean install -U spring-boot:run`
    
- to use method 1: you must have maven on the RHEL machine

Method 2
--------
- Build a jar and copy it to the RHEL machine, go to the directory
where the jar is and type the following command:

`nohup java -jar kafka_producer.jar &`