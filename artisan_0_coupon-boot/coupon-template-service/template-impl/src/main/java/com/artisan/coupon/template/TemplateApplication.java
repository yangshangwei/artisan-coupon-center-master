package com.artisan.coupon.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author 小工匠
 * @version 1.0
 * @description: 启动类
 * @date 2022/11/19 20:59
 * @mark: show me the code , change the world
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.artisan"})
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}
    