package cn.hnx.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by viruser on 2018/8/15.
 */

@Controller
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置viewController,提供映射路径
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/webSocket").setViewName("/webSocket");
    }
}
