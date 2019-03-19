package yyy.service;

import yyy.pojo.Cart;
import yyy.vo.VCart;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CartService {
    //展示用户的购物车
     List<VCart> showUserCart(Integer uid);

    //添加菜品到购物车
     void addFoodToCart(Cart cart, HttpSession session);

    //从购物车删除菜品
    void deleteByPrimaryKey(Integer cid);

}
