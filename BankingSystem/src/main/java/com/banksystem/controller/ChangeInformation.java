package com.banksystem.controller;

import com.banksystem.dao.UserImpl;
import com.banksystem.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * description: ChangeInformation <br>
 * version: 1.0 <br>
 */
@Controller
@ResponseBody
public class ChangeInformation {
    UserImpl userImpl = new UserImpl();

    @RequestMapping("/changeMultiple")
    public String changeMultiple(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Integer userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a request to change multiple user information, ID: " + userId);
        User user = new User();
        user.setID(userId);
        user.setAddress(httpServletRequest.getParameter("newAddressMultiple"));
        user.setName(httpServletRequest.getParameter("newNameMultiple"));
        user.setPhoneNumber(httpServletRequest.getParameter("newTelephoneNumberMultiple"));
        httpSession.setAttribute("loginUserName", user.getName());
        httpSession.setAttribute("loginUserPhoneNumber", user.getPhoneNumber());
        httpSession.setAttribute("loginUserAddress", user.getAddress());
        System.out.println("The user will be modified to: " + user);
        userImpl.changeInformation(user);
        return "Modification successful";
    }

    @RequestMapping("/changeNameSingle")
    public String changeNameSingle(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        String newName = httpServletRequest.getParameter("newNameSingle");
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("name", newName);
        userImpl.changeName(map);
        httpSession.setAttribute("loginUserName", newName);
        System.out.println("Received a request to change the user's name, ID: " + httpServletRequest.getSession().getAttribute("loginUserId") + ", the name will be changed to: " + newName);
        return "Modification successful";
    }

    @RequestMapping("/changeAddressSingle")
    public String changeAddressSingle(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        String newAddress = httpServletRequest.getParameter("newAddressSingle");
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("address", newAddress);
        userImpl.changeAddress(map);
        httpSession.setAttribute("loginUserAddress", newAddress);
        System.out.println("Received a request to change the user's address, ID: " + httpServletRequest.getSession().getAttribute("loginUserId") + ", the new address will be changed to: " + newAddress);
        return "Modification successful";
    }

    @RequestMapping("/changeTelephoneNumberSingle")
    public String changeTelephoneNumberSingle(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        String telephoneNumber = httpServletRequest.getParameter("newTelephoneNumberSingle");
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("phoneNumber", telephoneNumber);
        userImpl.changePhoneNumber(map);
        httpSession.setAttribute("loginUserPhoneNumber", telephoneNumber);
        System.out.println("Received a request to change the user's phone number, ID: " + httpServletRequest.getSession().getAttribute("loginUserId") + ", the new phone number will be changed to: " + telephoneNumber);
        return "Modification successful";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        Map<String, Object> map = new HashMap<String, Object>();
        String newPassword = httpServletRequest.getParameter("newPassword");
        map.put("id", httpServletRequest.getSession().getAttribute("loginUserId"));
        map.put("password", newPassword);
        userImpl.changePassword(map);
        System.out.println("Received a request to change the user's password, ID: " + httpServletRequest.getSession().getAttribute("loginUserId") + ", the password will be changed to: " + newPassword);
        httpSession.setAttribute("loginUserPassword", newPassword);

        return "Modification successful";
    }
}