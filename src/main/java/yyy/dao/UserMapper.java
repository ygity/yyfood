package yyy.dao;

import yyy.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    //添加用户，既注册
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //通过用户名查找用户——登录
    User selectByName(String name);
}