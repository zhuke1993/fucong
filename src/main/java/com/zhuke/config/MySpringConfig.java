package com.zhuke.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by ZHUKE on 2015/10/27.
 */
@Configuration
@ComponentScan(basePackages = "com.zhuke")
@ImportResource("classpath:MyApplicationContext.xml")
public class MySpringConfig {
    
}
