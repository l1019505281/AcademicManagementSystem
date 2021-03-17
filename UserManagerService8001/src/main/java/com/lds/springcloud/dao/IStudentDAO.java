package com.lds.springcloud.dao;

import com.lds.springcloud.entities.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IStudentDAO {
    /**
     * 增加新学生
     * @param user
     * @return 1成功0失败
     */
    public int create(Student user);

    /**
     * 删除学生（根据user_id）
     * @param id
     * @return
     */
    public int deleteStudent(Integer id);

    /**
     * 根据uid查询学生
     * @param uid
     * @return
     */
    public Student getByuid(Integer uid);
}
