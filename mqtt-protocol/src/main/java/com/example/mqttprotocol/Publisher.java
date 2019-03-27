package com.example.mqttprotocol;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {


    public  void publish() throws MqttException {

        String messageString = "HelloWorld";

        MqttConnectOptions options = new MqttConnectOptions();
//        options.setUserName("9vsnh4n6gb53-8VJi4K8CqmsN1CTcfAM");
//        options.setPassword("NdqSkEwbtMBVlKTQmoJdhBjPvdJxqkcbLYycjNESEcltNXccYBNPLgFQYwdQEgRM".toCharArray());
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);

        MqttClient client = new MqttClient("tcp://test.mosquitto.org:1883", MqttClient.generateClientId());
        client.connect(options);
        MqttMessage message = new MqttMessage();
        message.setPayload(messageString.getBytes());
        message.setRetained(true);
        client.publish("JCH", message);
        client.disconnect();

  }


}
