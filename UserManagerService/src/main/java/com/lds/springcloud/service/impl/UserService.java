package com.lds.springcloud.service.impl;

import com.lds.springcloud.dao.IUserDAO;
import com.lds.springcloud.entities.User;
import com.lds.springcloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
    public int deleteUser(User user) {
        return userDAO.deleteUser(user);
    }
}
