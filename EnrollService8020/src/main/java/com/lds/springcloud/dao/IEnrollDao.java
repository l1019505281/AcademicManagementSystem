package com.lds.springcloud.dao;


import com.lds.springcloud.entities.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IEnrollDao {
    Integer addEnroll(@Param("cno") Integer cno,@Param("sno") Integer sno);

    List<Course> queryCourses(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("query") String query, @Param("sno") Integer sno);

    int getTotalOfScore(@Param("query") String query, @Param("sno") Integer sno);
}
