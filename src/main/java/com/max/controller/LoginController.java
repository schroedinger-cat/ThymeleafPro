package com.max.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("/userLogin")
    public String userLogin(String username, String password, Model model, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //跳转主页面
            session.setAttribute("user",username);
            return "redirect:/main";

        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }


    }


}
