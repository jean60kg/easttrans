package com.ruoyi.feign.controller;

import com.ruoyi.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2020/5/21.
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "getFeignQuery", method = RequestMethod.GET)
    public int getFeignQuery() {
        return feignService.queryCount();
    }

}
