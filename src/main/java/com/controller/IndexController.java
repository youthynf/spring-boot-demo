package com.controller;

import com.config.TestConfig;
import com.service.TestService;
import com.service.impl.TestService1Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private TestService1Impl testService1;

    @Autowired
    private TestConfig testConfig;

    @RequestMapping("/unitTest")
    public String unitTest() {
        System.out.println("unit_test");
        return "unit_test";
    }

    @RequestMapping("/dynasty")
    public String dynasty(String serviceName) {
        System.out.println(serviceName);
        System.out.println(testService1);
        TestService queryService = testConfig.createQueryService(serviceName);
        System.out.println(queryService);
        return queryService.getContext();
    }
}
