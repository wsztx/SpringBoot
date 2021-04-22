package com.universe.springboot.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpringApplicationContextRegister implements ApplicationContextAware {

    public SpringApplicationContextRegister() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringApplicationContextUtil.setApplicationContext(applicationContext);
        log.info("Register ApplicationContext.");
    }
}
