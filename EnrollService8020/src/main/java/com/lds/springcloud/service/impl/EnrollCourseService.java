package com.lds.springcloud.service.impl;

import com.lds.springcloud.dao.IEnrollDao;
import com.lds.springcloud.entities.Course;
import com.lds.springcloud.service.IEnrollCourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollCourseService implements IEnrollCourseService {

    @Autowired
    IEnrollDao enrollDao;

    @Override
    public Integer enrollCourse(Integer cno, Integer sno) {
        return enrollDao.addEnroll(cno,sno);
    }

    @Override
    public List<Course> getCourses(Integer pageNum, Integer pageSize, String query, Integer sno) {
        if (pageNum-1 >= 0) {
            pageNum = (pageNum-1)*pageSize;
        }
        if (true) {
            query = query + "%";
        }
        return enrollDao.queryCourses(pageNum,pageSize,query,sno);
    }

    @Override
    public int getTotalOfScore(String query, Integer sno) {
        return enrollDao.getTotalOfScore(query,sno);
    }
}
