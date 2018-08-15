package cn.hnx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by viruser on 2018/8/15.
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages={"cn.hnx"})
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
