package yyy.service;


import yyy.pojo.User;



public interface UserService {

    public void register (User user);

    //通过用户名查找用户——登录
      User login(String username,String password);



}
