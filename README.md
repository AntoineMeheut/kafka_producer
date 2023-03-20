<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![GNU License][license-shield]][license-url]

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/AntoineMeheut/kafka_producer">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Kafka Java Producer</h3>

  <p align="center">
    Code produced to check the technical feasibility of writing in a Kafka topic events from a java application. This project is the part that injects events into a Kafka topic. This code can be used to inject events.
    <br />
    <a href="https://kafka.apache.org/documentation/"><strong>Explore Kafka docs</strong></a>
    <br />
    <br />
    <a href="https://github.com/AntoineMeheut/kafka_producer">View Demo</a>
    ·
    <a href="https://github.com/AntoineMeheut/kafka_producer/issues">Report Bug</a>
    ·
    <a href="https://github.com/AntoineMeheut/kafka_producer/issues">Request Feature</a>
  </p>
</p>

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [The code is based on](#The-code-is-based-on)
  * [The components of this project are](#The-components-of-this-project-are)
* [Getting Started](#getting-started)
  * [Installation](#installation)
* [Usage](#usage)
  * [Build for the first time](#Build-for-the-first-time)
  * [Execute the project](#Execute-the-project)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)

<!-- ABOUT THE PROJECT -->
## About The Project
Code produced to check the technical feasibility of writing in a Kafka topic events from a java application.

This project is the part that injects events into a Kafka topic.

This code can be used to inject events.

### The code is based on
* springframework.boot: to save time and quickly create an application executable on a ReadHat VM
* org.apache.kafka: which allows to open connection with the Kafka machine, connect to topic and write events there
* springframework.kafka: which saves time for everything concerns the use of Kafka in a Spring project

### The components of this project are
* a src/main/resources/application.properties file which contains the address of the Kafka machine
* the src/main/java/com/ame/messages/Producer.java class: main class which contains a run method for executing writes in the Kafka
* src/main/java/com/ame/messages/model/Message.java: class that defines the structure of messages sent to Kafka
	* msgID: Identification ID of the message type, example: "EVT" for event
	* msgTS: Timestamp of transmission of the stream, example: "2017-03-26-18.17.37.049316"
	* date: Summarized date of an event, example: "2018-02-27"
	* nuoff: Official number, example: 130
	* nucycle: Cycle number, example: 234156
	* nucycleg: General cycle number, example: 1
	* ctit: Type of intervention code, example: "110"
	* msgH: Timestamp of transmission of the stream with only the time, example: "18.17.37.049316"
	* topic: Indicates the name of the topic to which one wishes to inject the messages, example: "AME_AME.IN"
* src/main/java/com/ame/messages/incoming/MessagesPublisher.java: class which creates the messages that will be sent to Kafka
* src/main/java/com/ame/messages/config/ProducerChannelConfig.java: class who makes the connection to Kafka. There is no topic creation, because they are instantiated on the fly by sending messages
 
The project opens on Eclipse or IntelliJ.
 
<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Installation
 
1. Clone the repo
```
git clone https://github.com/AntoineMeheut/kafka_producer
```

<!-- USAGE EXAMPLES -->
## Usage
### Build for the first time

```
mvn clean install -U
```

### Execute the project
#### Method 1
* Copy the sources on a RHEL, place in the directory where is the pom of the project namely kafka_producer and type the command:

```
mvn clean install -U spring-boot:run
```
    
* to use method 1: you must have maven on the RHEL machine

#### Method 2
* Build a jar and copy it to the RHEL machine, go to the directory
where the jar is and type the following command:

```
nohup java -jar kafka_producer.jar &
```

<!-- ROADMAP -->
## Roadmap

See the [Project](https://github.com/AntoineMeheut/kafka_producer/projects) for a list of proposed features (and known issues).

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the GNU General Public License v3.0 License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

If you want to contact me [just clic](mailto:github.contacts@protonmail.com)

Project Link: [https://github.com/AntoineMeheut/kafka_producer](https://github.com/AntoineMeheut/kafka_producer)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/AntoineMeheut/kafka_producer?color=green
[contributors-url]: https://github.com/AntoineMeheut/kafka_producer/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/AntoineMeheut/kafka_producer
[forks-url]: https://github.com/AntoineMeheut/kafka_producer/network/members
[stars-shield]: https://img.shields.io/github/stars/AntoineMeheut/kafka_producer
[stars-url]: https://github.com/AntoineMeheut/kafka_producer/stargazers
[issues-shield]: https://img.shields.io/github/issues/AntoineMeheut/kafka_producer
[issues-url]: https://github.com/AntoineMeheut/kafka_producer/issues
[license-shield]: https://img.shields.io/github/license/AntoineMeheut/kafka_producer
[license-url]: https://github.com/AntoineMeheut/kafka_producer/blob/master/LICENSE
