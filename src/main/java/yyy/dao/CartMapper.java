package yyy.dao;

import yyy.pojo.Cart;
import yyy.vo.VCart;

import java.util.List;

public interface CartMapper {
    //从购物车删除菜品
    int deleteByPrimaryKey(Integer cid);

    int insert(Cart record);
    //添加菜品到购物车
    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);


    //展示用户的购物车
    List<VCart> showUserCart(Integer uid);

    //添加菜品到购物车
   // public void  addFoodToCart(Cart cart);




}