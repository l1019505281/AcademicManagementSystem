package com.lds.springcloud.dao;

import com.lds.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserDAO {
    /**
     * 增加新用户
     * @param user
     * @return 1成功0失败
     */
    public int create(User user);

    /**
     * 按id查询用户
     * @param id
     * @return User
     */
    public User queryById(@Param("id") Integer id);

    /**
     * 通过用户名密码查询用户
     * @param user
     * @return
     */
    public User queryByUsernameAndPassword(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    public int deleteUser(User user);
}
