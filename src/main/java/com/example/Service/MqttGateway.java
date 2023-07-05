package com.example.Service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {
    /**
     * 发送mqtt消息
     * @param topic 主题
     * @param payload 内容
     * @return void
     * @author Jackpot
     * @date 2021/9/7 12:20 下午
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, String payload);

    /**
     * 发送包含qos的消息
     * @param topic 主题
     * @param qos 对消息处理的几种机制。
     *          * 0 表示的是订阅者没收到消息不会再次发送，消息会丢失。<br>
     *          * 1 表示的是会尝试重试，一直到接收到消息，但这种情况可能导致订阅者收到多次重复消息。<br>
     *          * 2 多了一次去重的动作，确保订阅者收到的消息有一次。
     * @param payload 消息体
     * @return void
     * @author Jackpot
     * @date 2021/9/7 12:21 下午
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);

    /**
     * 发送包含qos的消息
     * @param topic 主题
     * @param qos 对消息处理的几种机制。
     *          * 0 表示的是订阅者没收到消息不会再次发送，消息会丢失。<br>
     *          * 1 表示的是会尝试重试，一直到接收到消息，但这种情况可能导致订阅者收到多次重复消息。<br>
     *          * 2 多了一次去重的动作，确保订阅者收到的消息有一次。
     * @param payload 消息体
     * @return void
     * @author Jackpot
     * @date 2021/9/7 12:21 下午
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, byte[] payload);

    void sendMessage(Message<?> message);
}
