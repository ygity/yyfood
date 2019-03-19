package yyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyy.common.JsonBean;
import yyy.pojo.FoodType;
import yyy.service.FoodTypeService;
import yyy.util.JsonUtils;

import java.util.List;

@Controller
public class FoodTypeController {

    @Autowired
    private FoodTypeService foodTypeService;

    @RequestMapping("/findAllByStandard.do")
    @ResponseBody
    public JsonBean findAllByStandard(Integer standard){

        JsonBean bean = null;
        try {
            List<FoodType> foodType = foodTypeService.findAllByStandard(standard);
            bean = JsonUtils.createJsonBean(1,foodType);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }

        return  bean;
    }
}
