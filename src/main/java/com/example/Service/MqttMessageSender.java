package com.example.Service;


import com.example.config.MqttOutboundConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MqttMessageSender {

    @Autowired
    private MqttOutboundConfiguration.MessageGateway mqttGateway;

    /**
     * 发送mqtt消息
     * @param topic 主题
     * @param message 内容
     * @return void
     * @author Jackpot
     * @date 2021/9/7 12:20 下午
     */
    public void send(String topic, String message) throws Exception {
        mqttGateway.sendToMqtt( message);
    }

    /**
     * 发送包含qos的消息
     * @param topic 主题
     * @param qos 质量
     * @param messageBody 消息体
     * @return void
     * @author Jackpot
     * @date 2021/9/7 12:21 下午
     */
    public void send(String topic, int qos, String messageBody){
   //     mqttGateway.sendToMqtt(topic, qos, messageBody);
    }

    /**
     * 发送包含qos的消息
     * @param topic 主题
     * @param qos 质量
     * @param message 消息体
     * @return void
     * @author Jackpot
     * @date 2021/9/7 12:21 下午
     */
    public void send(String topic, int qos, byte[] message){
   //     mqttGateway.sendToMqtt(topic, qos, message);
    }
}
