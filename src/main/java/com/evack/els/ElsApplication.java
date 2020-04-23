package com.evack.els;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={"com.evack.els"})
@MapperScan("com.evack.els.mapper")
public class ElsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElsApplication.class, args);
	}

}
