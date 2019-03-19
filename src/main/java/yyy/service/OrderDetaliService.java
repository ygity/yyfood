package yyy.service;

import yyy.pojo.OrderDetail;

import javax.servlet.http.HttpSession;

public interface OrderDetaliService {

     void  insertOrderSelective(OrderDetail orderDetail, HttpSession session);
}
