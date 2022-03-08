package com.demo.SpringJavaCodeConfig;

import com.demo.SpringAnnotation.Coach;
import com.demo.SpringAnnotation.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.demo.SpringAnnotation")
@PropertySource("classpath:Sport.properties")
public class SportConfig {

    //define for sad fortune service

    @Bean
    public FortuneService sadFortuneService()
    {
        return new SadFortuneService();
    }

    //define for swim coach and inject dependency

    @Bean
    public Coach swimCoach()
    {
        return new SwimCoach(sadFortuneService());
    }
}
