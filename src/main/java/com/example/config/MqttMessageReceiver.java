package com.example.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class MqttMessageReceiver implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        MessageHeaders headers = message.getHeaders();
        //获取消息Topic
        String receivedTopic = (String) headers.get(MqttHeaders.RECEIVED_TOPIC);
        log.info("[获取到的消息的topic :]{} ", receivedTopic);
        //获取消息体
        String payload = (String) message.getPayload();
        log.info("[获取到的消息的payload :]{} ", payload);
    }


}
