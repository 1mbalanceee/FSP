package com.politech.fsptenders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class FsptendersApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsptendersApplication.class, args);
	}

}
