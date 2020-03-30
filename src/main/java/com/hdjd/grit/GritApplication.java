package com.hdjd.grit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.hdjd.grit.mapper")
//@EnableSwagger2
public class GritApplication {

	public static void main(String[] args) {
		SpringApplication.run(GritApplication.class, args);
	}
}
