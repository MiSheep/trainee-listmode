package com.bosssoft.hr.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 继承SpringBootServletInitializer的类
 *
 * 若没有此类，则在使用外部Tomcat启动时，无法正确加载bean
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(TraineeListmodeApplication.class);
    }

}
