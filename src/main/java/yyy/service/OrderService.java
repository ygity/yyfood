package yyy.service;

import yyy.pojo.Order;
import yyy.vo.VOrder;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {

    //展示用户订单
     List<VOrder> findOrderByUid(HttpSession session);

    //添加用户订单,未用
     void  insertUserOrder(VOrder vorder, HttpSession session);

     void insertSelective(Order Order, HttpSession session);


}
