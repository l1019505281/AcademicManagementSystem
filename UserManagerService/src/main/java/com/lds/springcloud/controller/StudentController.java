package com.lds.springcloud.controller;

import com.lds.springcloud.entities.CommonResult;
import com.lds.springcloud.entities.Student;
import com.lds.springcloud.service.impl.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
