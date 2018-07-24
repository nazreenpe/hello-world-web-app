package com.nazreenpe.hello_world_practice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {
    @RequestMapping("")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/{name}")
    public String helloName(@PathVariable("name") String name) {
        return String.format("Hello %s, wazzup?", name);
    }
}
