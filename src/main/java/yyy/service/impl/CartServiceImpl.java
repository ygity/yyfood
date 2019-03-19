package yyy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yyy.dao.CartMapper;
import yyy.pojo.Cart;
import yyy.pojo.User;
import yyy.service.CartService;
import yyy.vo.VCart;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartdao;

    @Override
    public List<VCart> showUserCart(Integer uid) {
        List<VCart> list  = null;
        try {
            list = cartdao.showUserCart(uid);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e.getMessage());
        }


        return list;
    }

    @Override
    public void addFoodToCart(Cart cart, HttpSession session) {

       User user = (User) session.getAttribute("user");

        cart.setUid(user.getUid());
         cartdao.insertSelective(cart);
    }

    @Override
    public void deleteByPrimaryKey(Integer cid) {
        cartdao.deleteByPrimaryKey(cid);
    }
}
