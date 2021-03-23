package com.lds.springcloud.service;

import com.lds.springcloud.entities.Course;

import java.util.Date;
import java.util.List;

public interface ICourseService {
    Course queryCourse(Integer sno);

    Integer addCourse(Course course);

    List<Course> queryCourseByQuery(Integer pageNum, Integer pageSize, String query, Integer sno);

    int getTotalOfCourse();

    List<Course> getMyTeaching(Integer tno);

    Date getTimeEnroll(Integer cno);
}
