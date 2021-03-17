package com.lds.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.lds.springcloud.entities.CommonResult;
import com.lds.springcloud.entities.Student;
import com.lds.springcloud.service.impl.StudentService;
import com.lds.springcloud.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PutMapping(value = "/student/{sno}")
    public CommonResult login(Student student) {
        
        return new CommonResult(200, "success");
    }

    @DeleteMapping(value = "/student/{id}")
    public CommonResult delteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return new CommonResult(200, "success");
    }


    @GetMapping(value = "/student/getInfo")
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
        Student student = studentService.getStudent(id);
        if (student!=null) {
            json.put("role",role);
            json.put("student",student);
            return new CommonResult(200, "success", json);
        } else {
            return new CommonResult(404, "not found");
        }
    }
}
