package yyy.service;

import yyy.pojo.Food;
import yyy.vo.VFood;
import yyy.vo.VMenuInfo;

import java.util.List;
import java.util.Map;

public interface FoodService {

     List<VMenuInfo>findMenuInfo();

    //通过Id展示菜品
     List<VFood> FindFoodByPid(Integer pid);

    //展示所有商品—列表里的内容
     List<VFood> findFood();

    //分页展示
     Map<String,Object> showAllByPage(int page);

    //展示食物详细信息应用页面xiangqing
    //展示食物详细信息应用页面xiangqing
    VFood selectByPrimaryKey(Integer fid);
}
