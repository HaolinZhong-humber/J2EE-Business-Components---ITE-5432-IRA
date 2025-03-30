package com.banksystem.controller;

import com.banksystem.dao.UserImpl;
import com.banksystem.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * description: LoginController<br>
 * version: 1.0 <br>
 */

@Controller
public class LoginController {
    @RequestMapping("/user/login")//URL request address of the page
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession httpSession) {
        User user = new UserImpl().getUserById(Integer.parseInt(username));
        System.out.println("Received a user with username: " + username + " password: " + password + " name: " + user.getName() + ".");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.addAttribute("message", "Username or password is empty!!!");
            return "login";//Corresponds to login.html in templates
        } else {
            if (user.getPassword().equals(password)) {
                httpSession.setAttribute("loginUserId", username);
                httpSession.setAttribute("loginUserName", user.getName());
                httpSession.setAttribute("loginUserPhoneNumber", user.getPhoneNumber());
                httpSession.setAttribute("loginUserAddress", user.getAddress());
                httpSession.setAttribute("loginUserPassword", password);
                return "redirect:/index.html";//Corresponds to index.html in templates
            } else {
                model.addAttribute("message", "Username or password is incorrect!!!");
                return "login";//Corresponds to login.html in templates
            }
        }
    }

    @RequestMapping("/user/register")//URL request address of the page
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password, Model model) {
        User user = new User();
        user.setID(Integer.parseInt(username));
        user.setPassword(password);
        new UserImpl().addUser(user);
        System.out.println("Received a registration request for " + user);
        model.addAttribute("message", "Registration successful");
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login";
    }
}