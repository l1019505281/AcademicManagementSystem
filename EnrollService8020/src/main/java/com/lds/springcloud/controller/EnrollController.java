package com.lds.springcloud.controller;


import com.alibaba.fastjson.JSONObject;
import com.lds.springcloud.entities.CommonResult;
import com.lds.springcloud.entities.Course;
import com.lds.springcloud.service.impl.EnrollCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class EnrollController {
    @Autowired
    EnrollCourseService enrollService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/enroll/enrollCourse/{cno}/sno/{sno}")
    public CommonResult enrollCourse(@PathVariable("cno") Integer cno,@PathVariable("sno") Integer sno) {
        Boolean result=false;
        String getDate = restTemplate.getForObject("http://infoquery-service/infoquery/getTimeEnroll/" + cno, String.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        try {
            Date timeEnroll = dateFormat.parse(getDate);
            if (timeEnroll.after(currentDate)) {
                result = false;
            } else {
                result = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer res = null;
        if (result) {
            res = enrollService.enrollCourse(cno, sno);
            if (res == 1) {
                return new CommonResult(200, "success", res);
            }
        }
        return new CommonResult(201, "fail", res);
    }

    @GetMapping(value = "/enroll/getEnrollCourses/{sno}")
    public CommonResult getCourses(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestParam("query") String query, @PathVariable("sno") Integer sno) {
        List<Course> courses = enrollService.getCourses(pageNum,pageSize,query,sno);
        JSONObject json = new JSONObject();
        int total = enrollService.getTotalOfScore(query,sno);
        json.put("total",total);
        json.put("pageNum",pageNum);
        json.put("courses",courses);
        return new CommonResult(200, "success", json);
    }
}
