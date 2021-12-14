package de.gramou.log4j2vulnserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@ServletComponentScan
@SpringBootApplication
@Configuration
@EnableScheduling
@PropertySource("classpath:application.properties")
public class App 
{
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
