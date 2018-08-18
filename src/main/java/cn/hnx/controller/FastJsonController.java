package cn.hnx.controller;

import cn.hnx.common.bean.User;
import cn.hnx.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by viruser on 2018/8/18.
 */

@Controller
public class FastJsonController {

    @Autowired
    private WebSocketServer webSocketServer;

    @RequestMapping("/fastJson")
    @ResponseBody
    public User testFastJson(){
        User user = new User();
        user.setId(1);
        user.setUsername("test");
        user.setPassword("123456");
        user.setBirthday(new Date());
        return user;
    }
    @RequestMapping("/chat")
    public String chat(ModelMap modelMap) {
        modelMap.addAttribute("key", "qq");
        return "/chat";
    }
    @RequestMapping("/iChat")
    public String iChat(ModelMap modelMap) {
        modelMap.addAttribute("key", "qq");
        return "/iChat";
    }
}
