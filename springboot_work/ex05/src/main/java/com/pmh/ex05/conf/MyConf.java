package com.pmh.ex05.conf;

import com.pmh.ex05.obj.AA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.pmh.ex05.obj")
public class MyConf {

    @Bean
    public AA aa(){
        return new AA();
    }

}
