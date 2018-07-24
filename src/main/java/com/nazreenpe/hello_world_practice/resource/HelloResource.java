package com.nazreenpe.hello_world_practice.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {
    @RequestMapping("")
    public String hello() {
        return "Hello World!";
    }
}
