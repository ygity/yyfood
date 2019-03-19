package yyy.dao;

import yyy.pojo.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(OrderDetail record);

    int insertOrderSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}