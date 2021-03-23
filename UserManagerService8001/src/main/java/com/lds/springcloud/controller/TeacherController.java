package com.lds.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.lds.springcloud.entities.CommonResult;
import com.lds.springcloud.entities.Teacher;
import com.lds.springcloud.service.impl.TeacherService;
import com.lds.springcloud.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping(value = "/usermanager/teacher/getInfo")
    public CommonResult getStudent(@RequestHeader("Authorization") String token) {
        Integer id = null;
        String role = null;
        JSONObject json = new JSONObject();
        try {
            Map<String, Claim> map = JWTUtil.verifyToken(token);
            Claim idClaim = map.get("userId");
            Claim roleClaim = map.get("role");
            role = roleClaim.asString();
            String ids = idClaim.asString();
            id = Integer.parseInt(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id==null) {
            return new CommonResult(404, "not found");
        }
        Teacher teacher = teacherService.getTeacherByUid(id);
        if (teacher!=null) {
            json.put("role",role);
            json.put("info",teacher);
            return new CommonResult(200, "success", json);
        } else {
            return new CommonResult(404, "not found");
        }
    }
}
