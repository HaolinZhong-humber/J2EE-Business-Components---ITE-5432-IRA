package com.banksystem.controller;

import com.banksystem.dao.HistoryBillImpl;
import com.banksystem.pojo.Bill;
import com.banksystem.pojo.HistoryBill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * description: HistoryBillController <br>
 * version: 1.0 <br>
 */
@Controller
@ResponseBody
public class HistoryBillController {
    @RequestMapping("/historyBillList")
    public Collection<HistoryBill> list(HttpServletRequest httpServletRequest) {

        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a request to return the history bill list, ID: " + userId);
        Collection<HistoryBill> result = new HistoryBillImpl().getHistoryBillListById(userId);
        return result;
    }


    @RequestMapping("/deleteHistoryBill")
    public String deleteHistoryBill(HttpServletRequest httpServletRequest) {
        String balance = httpServletRequest.getParameter("balance");
        String type = httpServletRequest.getParameter("type");
        Bill bill = new Bill(Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId")), Double.parseDouble(balance), type);
        System.out.println("Received a request to delete a history bill, bill information: " + bill);
        new HistoryBillImpl().deleteHistoryBill(bill);
        return "Deletion successful!!!";
    }
}