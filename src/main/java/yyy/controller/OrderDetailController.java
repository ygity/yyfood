package yyy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yyy.common.JsonBean;
import yyy.pojo.OrderDetail;
import yyy.pojo.User;
import yyy.service.OrderDetaliService;
import yyy.util.JsonUtils;

import javax.servlet.http.HttpSession;


@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetaliService orderDetaliService;

    @RequestMapping("/insertOrderSelective.do")
    public JsonBean insertOrderSelective(OrderDetail orderDetail, HttpSession session){
        JsonBean bean = null;

        try {
            orderDetaliService.insertOrderSelective(orderDetail,session);
            bean = JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }


        return  bean;
    }

}
