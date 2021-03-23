package com.lds.springcloud.dao;

import com.lds.springcloud.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * @param id
     * @return
     */
    public int deleteUser(@Param("id") Integer id);

    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryAllUser();

    /**
     *  根据查询条件查询用户
     * @param pageNum
     * @param pageSize
     * @param query
     * @return
     */
    public List<User> queryUserByQuery(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize,@Param("query") String query);

    /**
     *
     * @return
     */
    public Integer totalOfUsers();

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public Integer editUser(User user);


    Integer getSnoByUid(@Param("uid") int uid);

    Integer getTnoByUid(@Param("uid") int uid);
}
