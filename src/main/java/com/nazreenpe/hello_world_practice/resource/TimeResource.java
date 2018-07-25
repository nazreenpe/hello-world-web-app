package com.nazreenpe.hello_world_practice.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/time")
public class TimeResource {
    @RequestMapping("")
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-Mm-dd HH:mm a");
        String localDateTime = LocalDateTime.now().format(formatter);
        return localDateTime;
    }
}
