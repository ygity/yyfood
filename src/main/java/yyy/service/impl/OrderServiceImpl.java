package yyy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yyy.dao.OrderDetailMapper;
import yyy.dao.OrderMapper;
import yyy.pojo.Order;
import yyy.pojo.OrderDetail;
import yyy.pojo.User;
import yyy.service.OrderService;
import yyy.vo.VOrder;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderDao;
    @Autowired
    private OrderDetailMapper detailDao;

    @Override
    public List<VOrder> findOrderByUid( HttpSession session) {
        List<VOrder> list = null;
        try {
            User user = (User) session.getAttribute("user");

            list = orderDao.findOrderByUid(user.getUid());

        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }

        return list;
    }

    //未引用
    @Override
    public void  insertUserOrder(VOrder  vorder,HttpSession session) {

      /*  Order order = new Order();
        order.setCreatedate( new Date());
        order.setUid(vOrder.getUid());
        order.setState(1);
        order.setTotalprice(vOrder.getTotalprice());
        order.setOrdernum(vOrder.getOrdernum());
        int oid = orderDao.insertSelective(order);
        List<OrderDetail> list = vOrder.getDetailList();
        for(OrderDetail orderDetail :list){
            orderDetail.setOid(oid);
            detailDao.insertOrderSelective(orderDetail);
        }
*/
/*

        User user = (User) session.getAttribute("user");
        order.setUid(user.getUid());
*/

       try {


           orderDao.insertUserOrder(vorder);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new  RuntimeException(e.getMessage());
        }


    }

    @Override
    public void insertSelective(Order order, HttpSession session) {



        try {
            User user = (User) session.getAttribute("user");
            order.setUid(user.getUid());

        } catch (Exception e) {
            e.printStackTrace();
            throw  new  RuntimeException(e.getMessage());
        }
    }


}
