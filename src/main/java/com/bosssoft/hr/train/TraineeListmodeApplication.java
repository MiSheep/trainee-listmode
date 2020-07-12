package com.bosssoft.hr.train;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@MapperScan("com.bosssoft.hr.train.dao")
@SpringBootApplication
@MapperScan("com.bosssoft.hr.train.mapper")
public class TraineeListmodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraineeListmodeApplication.class, args);
    }

}
