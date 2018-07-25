package com.nazreenpe.hello_world_practice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/time")
public class TimeResource {
    @RequestMapping("")
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        String localDateTime = LocalDateTime.now().format(formatter);
        return localDateTime;
    }

    @RequestMapping("/{format}")
    public String formatTime(@PathVariable("format") String format) {
        try {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
            return time;
        } catch (Exception e) {
            return "Error: Wrong format";
        }
    }
}
