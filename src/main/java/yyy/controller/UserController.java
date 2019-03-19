package yyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yyy.common.JsonBean;
import yyy.pojo.User;
import yyy.service.UserService;
import yyy.util.JsonUtils;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register.do")
    @ResponseBody
    public JsonBean  register(User user){

        JsonBean bean = null;

        try {

            userService.register(user);
            bean = JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonBean login(String username, String password, HttpSession session){
                JsonBean bean = null;

        try {
            User user = userService.login(username, password);
            session.setAttribute("user",user);
            bean = JsonUtils.createJsonBean(1,user);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }

            return  bean;
    }
}
