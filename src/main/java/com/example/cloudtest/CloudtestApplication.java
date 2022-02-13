package com.example.cloudtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication
@MapperScan("com.example.cloudtest.mapper")
public class CloudtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudtestApplication.class, args);
    }

}
