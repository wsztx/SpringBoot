package com.universe.springboot.web.controller;

import com.universe.springboot.common.enums.ResultCodeEnum;
import com.universe.springboot.common.exception.BusinessException;
import com.universe.springboot.entity.demo.Demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class HelloController {

    @GetMapping(value="/test")
    public Demo test(){
        throw new RuntimeException("123出错");
        //return new Demo();
    }

    @GetMapping(value="/test2")
    public Demo test2(){
        throw new BusinessException(ResultCodeEnum.FAIL);
        //return new Demo();
    }
}
