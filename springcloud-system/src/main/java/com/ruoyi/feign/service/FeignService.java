package com.ruoyi.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dell on 2020/5/21.
 */
@Component
@FeignClient(value = "springcloud-eureka-client")
public interface FeignService {

    @RequestMapping(value = "/user/queryCount", method = RequestMethod.GET)
    int queryCount();
}
