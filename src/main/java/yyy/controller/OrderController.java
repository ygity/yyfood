package yyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyy.common.JsonBean;
import yyy.pojo.Order;
import yyy.service.OrderService;
import yyy.util.JsonUtils;
import yyy.vo.VOrder;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/findOrderByUid.do")
    @ResponseBody
    public JsonBean findOrderByUid(HttpSession session) {
        JsonBean bean = null;

        try {
            List<VOrder> list = orderService.findOrderByUid(session);
            bean = JsonUtils.createJsonBean(1, list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0, e.getMessage());
        }

        return bean;
    }

    //未引用
    @RequestMapping("/insertUserOrder.do")
    @ResponseBody
    public JsonBean insertUserOrder(VOrder vOrder, HttpSession session) {
        JsonBean bean = null;
        try {
            orderService.insertUserOrder(vOrder, session);
            bean = JsonUtils.createJsonBean(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0, e.getMessage());
        }

        return bean;

    }
    @RequestMapping("/insertSelective.do")
    @ResponseBody
    public JsonBean insertSelective(Order order, HttpSession session) {
        JsonBean bean = null;
        try {
            orderService.insertSelective(order, session);
            bean = JsonUtils.createJsonBean(1, null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0, e.getMessage());
        }
        return bean;
    }
}
