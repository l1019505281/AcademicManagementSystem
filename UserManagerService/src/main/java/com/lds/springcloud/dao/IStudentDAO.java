package com.lds.springcloud.dao;

import com.lds.springcloud.entities.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IStudentDAO {
    /**
     * 增加新用户
     * @param user
     * @return 1成功0失败
     */
    public int create(Student user);

    /**
     * 删除用户（根据user_id）
     * @param id
     * @return
     */
    public int deleteStudent(Integer id);
}
