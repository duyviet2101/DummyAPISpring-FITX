package vn.edu.neu.fitx_first_spring_boot.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.neu.fitx_first_spring_boot.api.service.HelloWorldService;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping()
    public String sayHello() {
        return helloWorldService.sayHello();
    }
}
