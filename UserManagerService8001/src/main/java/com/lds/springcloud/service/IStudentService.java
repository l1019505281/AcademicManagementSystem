package com.lds.springcloud.service;


import com.lds.springcloud.entities.Student;

public interface IStudentService {

    /**
     * 创建学生
     * @param student
     * @return
     */
    public int create(Student student);

    /**
     * 删除学生(根据user_id)
     * @param id
     */
    public int deleteStudent(Integer id);

    /**
     * 得到学生信息
     * @param uid
     * @return
     */
    public Student getStudent(Integer uid);
}
