package yyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyy.common.JsonBean;
import yyy.pojo.Cart;
import yyy.pojo.User;
import yyy.service.CartService;
import yyy.util.JsonUtils;
import yyy.vo.VCart;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/showUserCart.do")
    @ResponseBody
    public JsonBean showUserCart(HttpSession session){

        JsonBean bean = null;
            User user = (User) session.getAttribute("user");
        try {
            List<VCart> list = cartService.showUserCart(user.getUid());
            bean = JsonUtils.createJsonBean(1,list);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return  bean;
    }

    @RequestMapping("/addFoodToCart.do")
    @ResponseBody
    public JsonBean addFoodToCart(Cart cart,HttpSession session){
        JsonBean bean = null;
        try {
            cartService.addFoodToCart(cart,session);
            bean = JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/deleteByPrimaryKey.do")
    @ResponseBody
    public JsonBean deleteByPrimaryKey(Integer cid){

        JsonBean bean = null;
        try {
            cartService.deleteByPrimaryKey(cid);
            bean = JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}
