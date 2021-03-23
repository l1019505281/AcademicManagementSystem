package com.lds.springcloud.service;

import com.lds.springcloud.entities.Course;

import java.util.List;

public interface IEnrollCourseService {

    Integer enrollCourse(Integer cno, Integer sno);

    List<Course> getCourses(Integer pageNum, Integer pageSize, String query, Integer sno);

    int getTotalOfScore(String query, Integer sno);
}
