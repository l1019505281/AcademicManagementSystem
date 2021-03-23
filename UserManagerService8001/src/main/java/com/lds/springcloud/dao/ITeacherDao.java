package com.lds.springcloud.dao;

import com.lds.springcloud.entities.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ITeacherDao {
    int create(Teacher teacher);

    int delelte(@Param("id") Integer id);

    Teacher getTeacherByUid(@Param("id") Integer id);
}
