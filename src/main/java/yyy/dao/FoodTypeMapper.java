package yyy.dao;

import yyy.pojo.FoodType;
import yyy.vo.VFoodType;

import java.util.List;

public interface FoodTypeMapper {
    int deleteByPrimaryKey(Integer typeid);

    int insert(FoodType record);

    int insertSelective(FoodType record);

    FoodType selectByPrimaryKey(Integer typeid);

    int updateByPrimaryKeySelective(FoodType record);

    int updateByPrimaryKey(FoodType record);

    //通过等级展示
    public List<FoodType> findAllByStandard(Integer standard);


}