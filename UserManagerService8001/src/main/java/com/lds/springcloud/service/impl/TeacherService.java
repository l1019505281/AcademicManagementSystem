package com.lds.springcloud.service.impl;

import com.lds.springcloud.dao.ITeacherDao;
import com.lds.springcloud.entities.Teacher;
import com.lds.springcloud.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherService implements ITeacherService {
    @Autowired
    ITeacherDao teacherDao;

    @Override
    public int create(Teacher teacher) {
        return teacherDao.create(teacher);
    }

    @Override
    public int deleteTeacher(Integer id) {
        return teacherDao.delelte(id);
    }

    @Override
    public Teacher getTeacherByUid(Integer id) {
        return teacherDao.getTeacherByUid(id);
    }
}
