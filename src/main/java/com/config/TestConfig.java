package com.config;

import com.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TestConfig implements InitializingBean, ApplicationContextAware{

    private Map<String, TestService> queryServiceImplMap = new HashMap<>();
    private ApplicationContext applicationContext;

    public TestService createQueryService(String serviceName) {
        TestService testService = queryServiceImplMap.get(serviceName);
        if(testService == null) {
            return queryServiceImplMap.get("TestService1Impl");
        }
        return testService;
    }

    /**
     * 实现InitializingBean接口，重写afterPropertiesSet属性注入后调用方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, TestService> beanMap = applicationContext.getBeansOfType(TestService.class);
        System.out.println(applicationContext);
        for(TestService serviceImpl : beanMap.values()) {
            // getName()返回包含包名，而getSimpleName()只返回类的名称
            queryServiceImplMap.put(serviceImpl.getClass().getSimpleName(), serviceImpl);
        }
        System.out.println(queryServiceImplMap);
    }

    /**
     * 实现ApplicationContextAware接口，重写setApplicationContext设置上下文
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
