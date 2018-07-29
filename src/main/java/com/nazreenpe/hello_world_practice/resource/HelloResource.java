package com.nazreenpe.hello_world_practice.resource;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/hello")
public class HelloResource {
    private int count;

    @RequestMapping(method = RequestMethod.GET, path = "", consumes = APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> hello() {
        Map map = new HashMap<String, String>();
        map.put("Message", "Hello World!");
        return map;
    }

    @RequestMapping(path = "/{name}", produces = "application/json")
    public ResponseEntity<Map<String, String>> helloName(@PathVariable("name") String name,
                                                         @RequestHeader("Content-Type") String contentType) {
        String message = String.format("Hello %s", name);
        Map map = new HashMap<String, String>();
        if (contentType.equals("application/json")) {
            if (name.equals("PokerFace")) {
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .header(HttpHeaders.LOCATION, "/hello")
                        .body(null);
            } else {
                map.put("message", message);
                return ResponseEntity
                        .ok(map);
            }
        } else {
            map.put("HTTP Status Code", "Unsupported Media Type");
            return ResponseEntity
                    .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                    .body(null);

        }
    }

    @RequestMapping(path = "/greet/{name}")
    public void greeting(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        String output = String.format("Hello! Welcome %s", name);
        PrintWriter writer = response.getWriter();
        writer.write(output);
    }

    @RequestMapping(path = "/message", produces = "application/json")
    public ResponseEntity<Map<String, String>> getAlternateMessage() {
        count += 1;
        if (count % 2 == 0) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("message", "Lucky You!");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(map);
        } else {
            return ResponseEntity
                    .status(404)
                    .body(null);
        }
    }

    @RequestMapping(path = "/message/{name}")
    public void messageForName(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        if (!name.equals("Naimer")) {
            PrintWriter writer = response.getWriter();
            String output = String.format("You have a message %s. It says you are amazing!", name);
            writer.write(output);
        } else {
            response.setStatus(404);
        }
    }

}
