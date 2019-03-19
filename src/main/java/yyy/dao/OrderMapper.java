package yyy.dao;

import yyy.pojo.Order;
import yyy.vo.VOrder;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

     List<VOrder> findOrderByUid(Integer uid);

    //未引用
    void insertUserOrder(VOrder vorder);
}