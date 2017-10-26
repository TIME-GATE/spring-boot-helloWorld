package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import com.neo.service.HelloWorldService;

@RestController
public class HelloWorldController {
	
    //@Autowired
    private HelloWorldService helloWorldService = new HelloWorldService();

    @RequestMapping(value = "/v1/api/getLabel", method = RequestMethod.GET)
    public String getLabel() {
        return helloWorldService.getLable();
    }

    @RequestMapping(value = "/v1/api/uploadModel", method = RequestMethod.GET)
    public String uploadModel(@RequestParam Map<String, String> request) {
        return request.get("pwd");
    }

    @RequestMapping(value = "/v1/api/sendContext", method = RequestMethod.GET)
    public String sendContext() {
        return "sdf";
    }

}
