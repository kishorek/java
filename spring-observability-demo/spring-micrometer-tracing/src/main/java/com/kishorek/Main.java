package com.kishorek;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Tracer tracer;

    @RequestMapping("/echo")
    public Map<String, Object> echo(@RequestParam Map<String, String> allRequestParams, @RequestHeader Map<String, String> allRequestHeaders, HttpServletRequest request) {
        log.info("Echo Key is used to summon an \"echo\" of a dead person to the Wellhouse");
        Map<String, Object> response = new HashMap<>();
        response.put("headers", allRequestHeaders);
        response.put("parameters", allRequestParams);
        return response;
    }

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        log.info("This is my house, I have to defend it.");

        Span echoSpan = tracer.nextSpan().name("calling-echo").start();
        String url = request.getRequestURL().toString();
        ResponseEntity<String> echoResponse = restTemplate.getForEntity(url + "/echo", String.class);
        log.info(echoResponse.getBody());
        echoSpan.end();

//        Span pythonSpan = tracer.nextSpan().name("calling-python").start();
        ResponseEntity<String> response = restTemplate.getForEntity(System.getenv("pyserver.endpoint"), String.class);
//        pythonSpan.end();
        return response.getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}