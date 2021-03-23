package com.lds.springcloud.service.impl;

import com.lds.springcloud.dao.ICourseDao;
import com.lds.springcloud.entities.Course;
import com.lds.springcloud.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    ICourseDao courseDao;

    @Override
    public Course queryCourse(Integer sno) {
        return courseDao.queryCourse(sno);
    }

    @Override
    public Integer addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    @Override
    public List<Course> queryCourseByQuery(Integer pageNum, Integer pageSize, String query, Integer sno) {
        if (pageNum-1 >= 0) {
            pageNum = (pageNum-1)*pageSize;
        }
        if (true) {
            query = query + "%";
        }
        return courseDao.queryCourseByQuery(pageNum,pageSize,query,sno);
    }

    @Override
    public int getTotalOfCourse() {
        return courseDao.getTotalOfCourse();
    }

    @Override
    public List<Course> getMyTeaching(Integer tno) {
        return courseDao.getMyTeaching(tno);
    }

    @Override
    public Date getTimeEnroll(Integer cno) {
        return courseDao.getTimeEnroll(cno);
    }


}
