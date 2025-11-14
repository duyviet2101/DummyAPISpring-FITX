package vn.edu.neu.fitx_first_spring_boot.api.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String sayHello() {
//        calculate something complex here
        return "Hello, World!";
    }
}
