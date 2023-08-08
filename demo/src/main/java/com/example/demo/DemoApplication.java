package com.example.demo;

import com.example.demo.db.connect.DataSource1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.example.demo.repository", "com.example.demo.model"})
//@Import({DataSource1Config.class})
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
