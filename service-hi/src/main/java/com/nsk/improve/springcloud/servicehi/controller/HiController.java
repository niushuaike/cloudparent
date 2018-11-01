package com.nsk.improve.springcloud.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Niusk
 * @create 2018/10/30
 */
@RestController
public class HiController {

    /**
     * 取配置文件中的值
     */
    @Value("${server.port}")
    String port;

    /**
     * 1、URL中？后的key=value，即为HTTP卸货中能够的Request参数
     * 2、PathValue和RequestParam注解都可从URL中获取参数
     * 3、PathValue为获取路径变量，从？前边获取参数
     * 4、RequestParam为获取Request参数，从？后边获取参数
     */
    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "Tom") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

}
