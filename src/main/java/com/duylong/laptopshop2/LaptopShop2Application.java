package com.duylong.laptopshop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// exclude >< include <loại bỏ> <chỉ định>
@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
})
public class LaptopShop2Application {

	public static void main(String[] args) {
		SpringApplication.run(LaptopShop2Application.class, args);
	}

}
