package com.lds.springcloud.controller;

import com.lds.springcloud.entities.CommonResult;
import com.lds.springcloud.entities.User;
import com.lds.springcloud.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    public CommonResult createUser(User user) {
        int result = userService.create(user);
        log.info("账号创建结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "账号创建成功", result);
        } else {
            return new CommonResult(400, "账号创建失败", result);
        }
    }
    @PostMapping(value = "/login")
    public CommonResult login(User user) {
        log.info(user.toString());
        User result = userService.login(user);
        log.info("账号登录结果：" + result);
        if (result != null) {
            return new CommonResult(200, "登录成功", result);
        } else {
            return new CommonResult(400, "用户名密码错误");
        }
    }

    @GetMapping(value = "/user/get/{id}")
    public CommonResult queryUser(@PathVariable("id") Integer id) {
        User result = userService.queryById(id);
        log.info("账号查询结果：" + result);
        if (result != null) {
            return new CommonResult(200, "查询到账号", result);
        } else {
            return new CommonResult(400, "账号不存在");
        }
    }

    @RequestMapping(value = "/config/info")
    public CommonResult getConfigInfo() {

    return new CommonResult(200, configInfo);
    }

    @RequestMapping(value = "/lb")
    public CommonResult getInfo() {

        return new CommonResult(200, serverPort);
    }
}
