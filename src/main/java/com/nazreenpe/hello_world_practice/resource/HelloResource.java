package com.nazreenpe.hello_world_practice.resource;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/hello")
public class HelloResource {
    @RequestMapping(method = RequestMethod.GET, path = "", consumes = APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> hello() {
        Map map = new HashMap<String, String>();
        map.put("Message", "Hello World!");
        return map;
    }

    @RequestMapping(path = "/{name}", produces = "application/json")
    public Map<String, String> helloName(@PathVariable("name") String name,
                                         @RequestHeader("Content-Type") String contentType,
                                         HttpServletResponse response) {
        String message = String.format("Hello %s", name);
        Map map = new HashMap<String, String>();
        if (contentType.equals("application/json")) {
            map.put("message", message);
            response.setStatus(200);
            return map;
        } else {
            response.setStatus(415);
            map.put("HTTP Status Code", "Unsupported Media Type");
        }
        return map;
    }

}
