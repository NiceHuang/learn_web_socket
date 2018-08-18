package cn.hnx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by viruser on 2018/8/16.
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("key", "testqq");
        return "/index";
    }
}
