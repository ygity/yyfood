package yyy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yyy.dao.FoodTypeMapper;
import yyy.pojo.FoodType;
import yyy.service.FoodTypeService;

import java.util.List;
@Service
public class FoodTypeServiceImpl implements FoodTypeService {

    @Autowired
    private FoodTypeMapper FoodTypeDao;
    //通过等级展示
    @Override
    public List<FoodType> findAllByStandard(Integer standard) {

        List<FoodType> list = null;

        try {
            list =  FoodTypeDao.findAllByStandard(standard);

        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }
        return list;
    }
}
