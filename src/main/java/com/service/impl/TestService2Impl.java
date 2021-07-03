package com.service.impl;

import com.service.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestService2Impl implements TestService {
    @Override
    public String getContext() {
        return "TestService2Impl";
    }
}
