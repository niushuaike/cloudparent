package com.nsk.improve.springcloud.servicefeign.utils;

import com.nsk.improve.springcloud.servicefeign.feignapi.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author Niusk
 * @create 2018/10/31
 */
@Component
public class SchedulelServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
