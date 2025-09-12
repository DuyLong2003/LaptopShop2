package com.duylong.laptopshop2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index() {
        return "Hello World with DuyLong! updated";
    }

    @GetMapping("/user")
    public String userPage() {
        return "Only for user!";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Only for admin!";
    }
}
