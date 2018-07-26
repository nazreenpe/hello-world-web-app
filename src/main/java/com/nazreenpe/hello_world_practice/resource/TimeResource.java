package com.nazreenpe.hello_world_practice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/time")
public class TimeResource {
    @RequestMapping("")
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        String localDateTime = LocalDateTime.now().format(formatter);
        return localDateTime;
    }

    @RequestMapping(path = "/{format}", consumes = "application/json", produces = "application/json")
    public Map<String, String > formatTime(@PathVariable("format") String format, HttpServletResponse response) {
        try {
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
            Map map = new HashMap<String, String>();
            map.put("datetime", time);
            return map;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            Map errorMessage = new HashMap<String, String>();
            errorMessage.put("Error", "Wrong Format");
            return errorMessage;
        }
    }
}
