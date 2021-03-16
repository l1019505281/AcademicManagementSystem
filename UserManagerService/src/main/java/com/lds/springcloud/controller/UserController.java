package com.lds.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.lds.springcloud.entities.CommonResult;
import com.lds.springcloud.entities.Menus;
import com.lds.springcloud.entities.Student;
import com.lds.springcloud.entities.User;
import com.lds.springcloud.service.impl.StudentService;
import com.lds.springcloud.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.lds.springcloud.util.JWTUtil;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
//@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/users")
    public CommonResult createUser(User user) {

        //改为事务
        int result = userService.create(user);
        if ("student".equals(user.getRole())) {
            int result2 = studentService.create(new Student(user.getUserId()));
        }
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
        User user1 = userService.login(user);
        log.info("账号登录结果：" + user1);
        if (user1 != null) {
            String token = null;
            JSONObject result = new JSONObject();
            try {
                token = JWTUtil.createToken(user1.getUserId().toString(),user1.getUsername(),user1.getRole());
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.put("username",user1.getUsername());
            result.put("role",user1.getRole());
            result.put("userId",user1.getUserId());
            result.put("token",token);
            return new CommonResult(200, "登录成功", result);
        } else {
            return new CommonResult(400, "用户名密码错误");
        }
    }

    @GetMapping(value = "/users/{id}")
    public CommonResult queryUser(@PathVariable("id") Integer id) {
        User user = userService.queryById(id);
        log.info("账号查询结果：" + user);
        if (user != null) {
            String token = null;
            JSONObject result = new JSONObject();
            try {
                token = JWTUtil.createToken(user.getUserId().toString(),user.getUsername(),user.getRole());
            } catch (Exception e) {
                e.printStackTrace();
            }
            result.put("username",user.getUsername());
            result.put("role",user.getRole());
            result.put("userId",user.getUserId());
//            result.put("token",token);
            return new CommonResult(200, "查询到账号", result);
        } else {
            return new CommonResult(400, "账号不存在");
        }
    }

    @GetMapping(value = "/menus")
    public CommonResult getUserMenus(@RequestHeader("Authorization") String token) {
        String role = null;
        List<Menus> menusList = null;
        try {
            Map<String, Claim> map = JWTUtil.verifyToken(token);
            Claim roleClaim = map.get("role");
            role = roleClaim.asString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ("admin".equals(role)) {
            menusList = Menus.getAdminMenuList();
        } else if ("student".equals(role)) {
            menusList = Menus.getStudentMenuList();
        } else if ("teacher".equals(role)) {
            menusList = Menus.getTeacherMenuList();
        }
        return new CommonResult(200, "success", menusList);
    }

    @RequestMapping(value = "/users")
    public CommonResult getUserList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestParam("query") String query) {
        List<User> users = userService.queryUserByQuery(pageNum, pageSize, query);
        int total = userService.getTotalOfUser();
        JSONObject json = new JSONObject();
        json.put("total",total);
        json.put("pageNum",pageNum);
        json.put("users",users);
        return new CommonResult(200, "success", json);
    }

    @DeleteMapping(value = "/users/{id}")
    public CommonResult delteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        studentService.deleteStudent(id);
        return new CommonResult(200, "success");
    }

    @PutMapping(value = "/users/{id}")
    public CommonResult editUser(@PathVariable("id") Integer id, User user) {
        user.setUserId(id);
        userService.editUser(user);
        return new CommonResult(200, "success");
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
