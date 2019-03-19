package yyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yyy.common.JsonBean;
import yyy.pojo.Food;
import yyy.service.FoodService;
import yyy.util.JsonUtils;
import yyy.vo.VFood;
import yyy.vo.VMenuInfo;

import java.util.List;
import java.util.Map;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping("/findMenuInfo.do")
    public JsonBean findMenuInfo(){
        JsonBean bean = null;

        try {
            List<VMenuInfo> list = foodService.findMenuInfo();
            bean = JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }

        return  bean;
    }

    //通过Id展示菜品主要页面index
    @RequestMapping("/FindFoodByPid.do")
    public  JsonBean FindFoodByPid(Integer pid){
        JsonBean bean = null;
        try {
            List<VFood> list = foodService.FindFoodByPid(pid);
            bean = JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return  bean;
    }

    //展示所有菜品主要页面liebiao
    @RequestMapping("/FindFood.do")
    public  JsonBean FindFood(){
        JsonBean bean = null;
        try {
            List<VFood> list = foodService.findFood();
            bean = JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return  bean;
    }

    @RequestMapping("/showAllByPage.do")
    public  JsonBean showAllByPage(int page){
        JsonBean bean = null;
        try {
            Map<String,Object> map = foodService.showAllByPage(page);
            bean = JsonUtils.createJsonBean(1, map);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0, e.getMessage());

        }
        return bean;
    }
    @RequestMapping("/selectByPrimaryKey.do")
    public  JsonBean selectByPrimaryKey(Integer fid){
        JsonBean bean = null;
        try {
            VFood vfood = foodService.selectByPrimaryKey(fid);
            bean = JsonUtils.createJsonBean(1,vfood);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}
