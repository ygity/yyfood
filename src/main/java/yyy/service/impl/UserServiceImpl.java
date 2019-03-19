package yyy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyy.dao.UserMapper;
import yyy.pojo.FoodType;
import yyy.pojo.User;
import yyy.service.UserService;
import yyy.util.JsonUtils;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public void register(User user) {

        /*String md5password = MD5utils.encode(user.getPassword());
        user.setPassword(md5password);*/
         /*  user.getPassword();*/
        try {

            userDao.insert(user);

        } catch (Exception e) {
            e.printStackTrace();
            throw  new  RuntimeException(e.getMessage());
        }

    }

    //通过用户名查找用户——登录
    @Override
    public User login(String username, String password) {
        User user = userDao.selectByName(username);
        if (username == null){
            throw  new  RuntimeException("用户名错误");
        }
        if (!user.getPassword().equals(password)){
            throw  new  RuntimeException("密码错误");
        }

        return user;
    }


}
