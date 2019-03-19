package yyy.dao;

import yyy.pojo.Food;
import yyy.vo.VFood;
import yyy.vo.VMenuInfo;

import java.util.List;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(Food record);

    int insertSelective(Food record);

     //展示食物详细信息应用页面xiangqing
    VFood selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
    //展示餐单列表
    public List<VMenuInfo> findMenuInfo();

    //通过Id展示菜品
    public List<VFood> FindFoodByPid(Integer pid);

    //展示所有商品—列表里的内容
    public List<VFood> findFood();

    //分页展示
    public List<VFood> showAllByPage();

    //展示食物详细信息应用页面xiangqing



}