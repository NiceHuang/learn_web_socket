package cn.hnx.controller;

import cn.hnx.common.bean.AricMessage;
import cn.hnx.common.bean.AricResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by viruser on 2018/8/15.
 */

@Controller
public class WebSocketController {

    @MessageMapping("/welcome") //当浏览器向服务端发送请求时,通过@MessageMapping映射/welcome这个地址,类似于@ResponseMapping
    @SendTo("/topic/getResponse")//当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
    public AricResponse say(@RequestBody AricMessage message) {
        try {
            //睡眠1秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AricResponse("welcome," + message.getName() + "!");
    }
}
