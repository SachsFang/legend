package com.fang.legend.addons.websocket_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SachsFang on 2021/5/19 20:07
 */
@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/helloSocket")
    public String index() {
        return "/websocket/websocket";
    }

    @MessageMapping("/changeNotice")
    public void greeting(String value) {
        System.out.println("我发了");
        simpMessagingTemplate.convertAndSend("/topic/notice", value);
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void scheduled() {
        System.out.println("怎么不行有待解决");
    }
}
