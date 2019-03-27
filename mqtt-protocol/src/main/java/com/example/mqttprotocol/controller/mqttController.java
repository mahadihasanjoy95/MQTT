package com.example.mqttprotocol.controller;

import com.example.mqttprotocol.Subscriber;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Controller
public class mqttController {
    Subscriber subscriber;


    @RequestMapping("/subscribeTest")
    @ResponseBody
    public String Message() throws MqttException, InterruptedException {



        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        final String[] A = new String[1];
        MqttClient client=new MqttClient("tcp://test.mosquitto.org:1883", MqttClient.generateClientId());

        client.connect();
        client.subscribe("JCH",(s, mqttMessage) ->{
            byte[] payload = mqttMessage.getPayload();
            String returnValue=new String(payload);
            A[0] =returnValue;
        });

        return A[0];
    }



}
