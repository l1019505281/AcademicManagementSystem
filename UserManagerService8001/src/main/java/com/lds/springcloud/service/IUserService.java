package com.lds.springcloud.service;

import com.lds.springcloud.entities.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
     * @param id
     * @return
     */
    public int deleteUser(Integer id);

    /**
     * 查找所有用户
     * @return
     */
    public List<User> queryAllUser();

    /**
     * 根据查询条件查询分页的结果
     * @param pageNum 第几页
     * @param pageSize 一页显示多少
     * @param query 查询条件
     * @return
     */
    public List<User> queryUserByQuery(Integer pageNum, Integer pageSize, String query);

    /**
     * 得到用户的总数
     * @return
     */
    public Integer getTotalOfUser();

    /**
     * 修改用户信息
     * @return
     */
    public Integer editUser(User user);

    Integer getSnoByUid(Integer uid);

    Integer getTnoByUid(Integer uid);
}
