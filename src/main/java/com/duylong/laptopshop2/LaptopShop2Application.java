package com.duylong.laptopshop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaptopShop2Application {

	public static void main(String[] args) {
		SpringApplication.run(LaptopShop2Application.class, args);
	}

	// In ra tất cả bean có trong Spring IoC
	// container
	// ApplicationContext duylong =
	// SpringApplication.run(LaptopShop2Application.class, args);
	// for (String s : duylong.getBeanDefinitionNames()) {
	// System.out.println(s);
	// }
	// }
}
