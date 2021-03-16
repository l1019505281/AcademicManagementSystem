package com.lds.springcloud.controller;

import com.lds.springcloud.entities.CommonResult;

public class InfoQueryController {



    public CommonResult getMyInfo() {
        return new CommonResult(200, "success");
    }
}
