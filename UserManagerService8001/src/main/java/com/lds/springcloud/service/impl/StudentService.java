package com.lds.springcloud.service.impl;

import com.lds.springcloud.dao.IStudentDAO;
import com.lds.springcloud.entities.Student;
import com.lds.springcloud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentService")
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public int create(Student student) {
        return studentDAO.create(student);
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentDAO.deleteStudent(id);
    }

    @Override
    public Student getStudent(Integer uid) {
        return studentDAO.getByuid(uid);
    }

}
