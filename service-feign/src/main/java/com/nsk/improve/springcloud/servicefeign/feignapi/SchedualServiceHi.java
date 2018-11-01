package com.nsk.improve.springcloud.servicefeign.feignapi;

import com.nsk.improve.springcloud.servicefeign.utils.SchedulelServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Niusk
 */
@FeignClient(value = "service-hi", fallback = SchedulelServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}