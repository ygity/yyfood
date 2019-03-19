package yyy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yyy.dao.FoodMapper;
import yyy.pojo.Food;
import yyy.service.FoodService;
import yyy.vo.VFood;
import yyy.vo.VMenuInfo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodDao;
    @Override
    public List<VMenuInfo> findMenuInfo() {

        List<VMenuInfo>  list = null;
        try {
            list = foodDao.findMenuInfo();

        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }

        return list;


    }
    //通过Id展示菜品
    @Override
    public List<VFood> FindFoodByPid(Integer pid) {
        List<VFood> list = null;
        try {
            list = foodDao.FindFoodByPid(pid);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }


        return list;
    }

    @Override
    public List<VFood> findFood() {
        List<VFood> list = null;
        try {
            list = foodDao.findFood();
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }
        return list;
    }

    @Override
    public Map<String, Object> showAllByPage(int page) {
        PageHelper.startPage(page,12);
        List<VFood> list = foodDao.showAllByPage();

        //list得到的是分页后的数据
        //创建对象
        Map<String,Object> map = new HashMap<>();

        //获取总数据条数
        map.put("total",((Page)list).getTotal());
        //map.put("total",pageInfo.getTotal());
        //获取记录
        map.put("rows",list);

        return map;
    }

    @Override
    public VFood selectByPrimaryKey(Integer fid) {
        VFood  vfood = null;
        try {
            vfood = foodDao.selectByPrimaryKey(fid);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new  RuntimeException(e.getMessage());
        }
        return vfood;
    }
}
