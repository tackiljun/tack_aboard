package org.astro.aboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.astro.aboard.**.mappers"})
public class AboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AboardApplication.class, args);
	}

}
