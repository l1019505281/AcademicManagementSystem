package com.lds.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.lds.springcloud.entities.CommonResult;
import com.lds.springcloud.entities.Course;
import com.lds.springcloud.entities.Score;
import com.lds.springcloud.service.impl.CourseService;
import com.lds.springcloud.service.impl.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class InfoQueryController {

    @Autowired
    CourseService courseService;

    @Autowired
    ScoreService scoreService;

    @GetMapping(value = "/infoquery/getMyInfo")
    public CommonResult getMyInfo() {

        return new CommonResult(200, "success", "getMyInfo");
    }

    @GetMapping(value = "/infoquery/getCourse/{sno}")
    public CommonResult getMyCourse(@PathVariable("sno") Integer sno) {

        Course course = courseService.queryCourse(sno);

        return new CommonResult(200, "success", course);
    }

    @GetMapping(value = "/infoquery/getScore/{cno}/sno/{sno}")
    public CommonResult getMyScore(@PathVariable("cno") Integer cno,@PathVariable("sno") Integer sno) {

        Score score = scoreService.getScore(cno, sno);

        return new CommonResult(200, "success", score);
    }

    @RequestMapping(value = "/infoquery/getCourse/query/{sno}")
    public CommonResult getMyCourseByQuery(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestParam("query") String query,@PathVariable("sno") Integer sno) {
        List<Course> courses = courseService.queryCourseByQuery(pageNum, pageSize, query, sno);
        int total = courseService.getTotalOfCourse();
        JSONObject json = new JSONObject();
        json.put("total",total);
        json.put("pageNum",pageNum);
        json.put("courses",courses);
        return new CommonResult(200, "success", json);
    }

    @RequestMapping(value = "/infoquery/getScore/query/{sno}")
    public CommonResult getMyScoreByQuery(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, @RequestParam("query") String query,@PathVariable("sno") Integer sno) {
        List<Score> scores = scoreService.queryScoreByQuery(pageNum, pageSize, query, sno);
        int total = scoreService.getTotalOfScore();
        JSONObject json = new JSONObject();
        json.put("total",total);
        json.put("pageNum",pageNum);
        json.put("scores",scores);
        return new CommonResult(200, "success", json);
    }

    @RequestMapping(value = "/infoquery/getMyTeaching/{tno}")
    public CommonResult getMyTeaching(@PathVariable("tno") Integer tno) {
        List<Course> courses = courseService.getMyTeaching(tno);
        return new CommonResult(200, "success", courses);
    }

    @PostMapping(value = "/infoquery/addCourse")
    public CommonResult addCourse(Course course) {
        Integer result = courseService.addCourse(course);
        return new CommonResult(200, "success", result);
    }

    @PostMapping(value = "/infoquery/addScore/")
    public CommonResult addScore(Score score) {
        Integer result = scoreService.addScore(score);
        return new CommonResult(200, "success", result);
    }


    @GetMapping(value = "/infoquery/getTimeEnroll/{cno}")
    public String getTimeEnroll(@PathVariable("cno") Integer cno) {
        Date result = courseService.getTimeEnroll(cno);
        SimpleDateFormat dateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result1 = dateFormat2.format(result);
        try {
            Date parse = dateFormat2.parse(result1);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result1;
    }



}
