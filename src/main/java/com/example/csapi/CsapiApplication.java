package com.example.csapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CsapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsapiApplication.class, args);
    }

}
