package com.universe.springboot.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

@Slf4j
public class SpringApplicationContextUtil {
    private static ApplicationContext applicationContext;

    public static synchronized void setApplicationContext(ApplicationContext applicationContext) {
        SpringApplicationContextUtil.applicationContext = applicationContext;
        log.info("ApplicationContext Registered.");
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }
}
