package com.lds.springcloud.service;

import com.lds.springcloud.entities.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
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
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    public int deleteUser(User user);
}
