package com.example.config;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@AllArgsConstructor
@Configuration
public class MqttOutboundConfiguration {

    private MqttConfig mqttConfig;
    private MqttPahoClientFactory factory;

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

//    @Bean
//    @ServiceActivator(inputChannel = "mqttOutboundChannel")
//    public MessageHandler mqttOutbound() {
//        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(
//                mqttConfig.getClientId()+"-"+System.currentTimeMillis() + System.currentTimeMillis(), factory);
//
//        messageHandler.setDefaultQos(0);
//        //开启异步
//        messageHandler.setAsync(true);
//        messageHandler.setDefaultTopic(mqttConfig.getTopic());
//        return messageHandler;
//    }


    @MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
    public interface MessageGateway {
        @Gateway(replyTimeout = 1, requestTimeout = 30)
        void sendToMqtt(String data) throws Exception;


    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(mqttConfig.getClientId(), factory);
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(mqttConfig.getTopic());
        messageHandler.setDefaultQos(2);
        return messageHandler;
    }

}
