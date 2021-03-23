package com.lds.springcloud.service.impl;

import com.lds.springcloud.dao.IUserDAO;
import com.lds.springcloud.entities.User;
import com.lds.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public int create(User user) {
        return userDAO.create(user);
    }

    @Override
    public User queryById(Integer id) {
        return userDAO.queryById(id);
    }

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User login(User user) {
        return userDAO.queryByUsernameAndPassword(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userDAO.deleteUser(id);
    }

    @Override
    public List<User> queryAllUser() {
        return userDAO.queryAllUser();
    }

    @Override
    public List<User> queryUserByQuery(Integer pageNum, Integer pageSize, String query) {
        if (pageNum-1 >= 0) {
            pageNum = (pageNum-1)*pageSize;
        }
        if (true) {
            query = query + "%";
        }
        return userDAO.queryUserByQuery(pageNum, pageSize, query);
    }

    @Override
    public Integer getTotalOfUser() {
        return userDAO.totalOfUsers();
    }

    @Override
    public Integer editUser(User user) {
        return userDAO.editUser(user);
    }

    @Override
    public Integer getSnoByUid(Integer uid) {
        return userDAO.getSnoByUid(uid);
    }

    @Override
    public Integer getTnoByUid(Integer uid) {
        return userDAO.getTnoByUid(uid);
    }
}
