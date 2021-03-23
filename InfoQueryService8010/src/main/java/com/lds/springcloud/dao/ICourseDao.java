package com.lds.springcloud.dao;


import com.lds.springcloud.entities.Course;
import com.lds.springcloud.entities.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ICourseDao {
    Course queryCourse(@Param("sno") Integer sno);

    Integer addCourse(Course course);

    List<Course> queryCourseByQuery(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("query") String query,@Param("sno") Integer sno);

    int getTotalOfCourse();

    List<Course> getMyTeaching(@Param("tno") Integer tno);

    Date getTimeEnroll(@Param("cno") Integer cno);
}
