package com.example.controller;

import com.example.Service.MqttMessageSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    MqttMessageSender sender;
    @PostMapping("/test")
    @ResponseBody
    public TraderResponseDto pushBankCardOrderList(@RequestBody TestRequest requestList) {
        TraderResponseDto dto = TraderResponseDto.builder().code("1").message("1") .build();
        return dto;
    }

    @GetMapping(value = "/x")
    @ResponseBody
    public String index() {
        return "Trader is running.";
    }

    @GetMapping(value = "/x2")
    @ResponseBody
    public String index2() throws Exception {
        sender.send("topic1","sss");
        return "Trader is running.";
    }
}
