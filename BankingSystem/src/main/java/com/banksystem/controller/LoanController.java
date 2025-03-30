package com.banksystem.controller;

import com.banksystem.dao.LoanImpl;
import com.banksystem.pojo.Loan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * description: LoanController <br>
 * version: 1.0 <br>
 */
@Controller
@ResponseBody
public class LoanController {
    @RequestMapping("/getLoan")
    public Collection<Loan> getLoan(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a request to return the loan list, ID: " + userId);
        return new LoanImpl().getLoan();
    }
}