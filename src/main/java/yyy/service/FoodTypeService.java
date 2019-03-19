package yyy.service;

import yyy.pojo.FoodType;

import java.util.List;

public interface FoodTypeService {

    //通过等级展示
     List<FoodType> findAllByStandard(Integer standard);

}
