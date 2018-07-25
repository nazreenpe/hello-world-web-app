package com.nazreenpe.hello_world_practice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloResource {
    @RequestMapping(path = "", consumes = "application/json", produces = "application/json")
    public Map<String, String> hello() {
        Map map = new HashMap<String, String>();
        map.put("Message", "Hello World!");
        return map;
    }

    @RequestMapping("/{name}")
    public String helloName(@PathVariable("name") String name) {
        return String.format("Hello %s, wazzup?", name);
    }
}
