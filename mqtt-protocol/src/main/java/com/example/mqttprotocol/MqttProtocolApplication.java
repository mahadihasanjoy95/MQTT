package com.example.mqttprotocol;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqttProtocolApplication {

	public static void main(String[] args) throws MqttException {
		Publisher publisher=new Publisher();
		Subscriber subscriber=new Subscriber();
		SpringApplication.run(MqttProtocolApplication.class, args);
		publisher.publish();
		subscriber.subscribing();

	}

}
