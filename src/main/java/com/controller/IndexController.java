package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/unitTest")
    public String unitTest() {
        System.out.println("unit_test");
        return "unit_test";
    }
}
