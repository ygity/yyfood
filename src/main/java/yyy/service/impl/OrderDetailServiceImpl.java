package yyy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yyy.dao.OrderDetailMapper;
import yyy.pojo.OrderDetail;
import yyy.pojo.User;
import yyy.service.OrderDetaliService;

import javax.servlet.http.HttpSession;

@Service
public class OrderDetailServiceImpl implements OrderDetaliService {


    @Autowired
    private OrderDetailMapper detailDao;
    @Override
    public  void insertOrderSelective(OrderDetail orderDetail, HttpSession session) {

        try {
            User user = (User) session.getAttribute("user");
            orderDetail.setUid(user.getUid());
            detailDao.insertOrderSelective(orderDetail);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new  RuntimeException(e.getMessage());
        }



    }
}
