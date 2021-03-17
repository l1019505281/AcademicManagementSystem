package com.lds.springcloud.controller;

import com.lds.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;

public class InfoQueryController {


    @GetMapping(value = "/getMyInfo")
    public CommonResult getMyInfo() {
        return new CommonResult(200, "success");
    }
}
