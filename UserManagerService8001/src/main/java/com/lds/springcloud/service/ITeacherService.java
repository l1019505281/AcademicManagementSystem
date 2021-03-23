package com.lds.springcloud.service;

import com.lds.springcloud.entities.Teacher;

public interface ITeacherService {
    int create(Teacher teacher);

    int deleteTeacher(Integer id);

    Teacher getTeacherByUid(Integer id);
}
