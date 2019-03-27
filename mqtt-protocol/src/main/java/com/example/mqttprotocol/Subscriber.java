package com.example.mqttprotocol;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.Arrays;

public class Subscriber {

  public void subscribing() throws MqttException {

      MqttClient client=new MqttClient("tcp://test.mosquitto.org:1883", MqttClient.generateClientId());
      client.connect();
      client.subscribe("ROY");
      client.setCallback( new SimpleMqttCallBack() );
  }

}
