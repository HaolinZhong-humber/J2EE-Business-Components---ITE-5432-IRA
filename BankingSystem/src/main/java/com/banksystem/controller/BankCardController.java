package com.banksystem.controller;

import com.banksystem.dao.BankCardImpl;
import com.banksystem.dao.HistoryBillImpl;
import com.banksystem.dao.UserBankCardImpl;
import com.banksystem.pojo.BankCard;
import com.banksystem.pojo.BankCardManage;
import com.banksystem.pojo.Bill;
import com.banksystem.pojo.BussinessType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * description: bankCardManageController <br>
 * version: 1.0 <br>
 */
@Controller
@ResponseBody
public class BankCardController {
    @RequestMapping("/bankCardList")
    public Collection<BankCardManage> bankCardList(HttpServletRequest httpServletRequest) {

        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a request to return the bank card list, ID: " + userId);
        return new BankCardImpl().getBankCardById(userId);
    }

    @RequestMapping("/changeBankcardPassword")
    public String changeBankcardPassword(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a request to change the bank card password, ID: " + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("password", httpServletRequest.getParameter("newPassword"));
        map.put("bankcardNumber", httpServletRequest.getParameter("bankcardNumber"));
        new BankCardImpl().changeInformation(map);
        return "Bank card password changed successfully";
    }

    @RequestMapping("/deleteBankcard")
    public String deleteBankcard(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a request to delete a bank card, ID: " + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        map.put("userid", userId);
        map.put("bankcardnumber", Integer.parseInt(bankcardNumber));
        new BankCardImpl().deleteBankCard(Integer.parseInt(bankcardNumber));
        new UserBankCardImpl().deleteBankCard(map);
        return "Bank card deleted successfully";
    }

    @RequestMapping("/depositMoney")
    public String depositMoney(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a deposit request, ID: " + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        double number = Integer.parseInt(httpServletRequest.getParameter("number"));
        map.put("bankcardNumber", bankcardNumber);
        map.put("number", number);
        new BankCardImpl().changeRemainingBalance(map);

        Bill bill = new Bill();
        bill.setpayee(userId);
        bill.settype(BussinessType.DEPOSIT.toString());
        bill.setvalue(number);
        new HistoryBillImpl().insertHistoryDepositBill(bill);
        return "Deposit successful";
    }

    @RequestMapping("/withdrawNumber")
    public String withdrawNumber(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a withdrawal request, ID: " + userId);
        Map<String, Object> map = new HashMap<String, Object>();
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        double number = -Integer.parseInt(httpServletRequest.getParameter("number"));
        map.put("bankcardNumber", bankcardNumber);
        map.put("number", number);
        new BankCardImpl().changeRemainingBalance(map);

        Bill bill = new Bill();
        bill.setsender(userId);
        bill.setvalue(number);
        bill.settype(BussinessType.WITHDRAWAL.toString());
        new HistoryBillImpl().insertHistoryWithdrawBill(bill);
        return "Withdrawal successful";
    }

    @RequestMapping("/transferMoney")
    public String transferMoney(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a transfer request, ID: " + userId);
        BankCardImpl bankCard = new BankCardImpl();
        String sender = httpServletRequest.getParameter("sender");
        String money = httpServletRequest.getParameter("money");
        String payee = httpServletRequest.getParameter("payee");
        Map<String, Object> mapSender = new HashMap<String, Object>();
        mapSender.put("bankcardNumber", sender);
        mapSender.put("number", -Integer.parseInt(money));
        Map<String, Object> mapPayee = new HashMap<String, Object>();
        mapPayee.put("bankcardNumber", payee);
        mapPayee.put("number", Integer.parseInt(money));
        bankCard.changeRemainingBalance(mapPayee);
        bankCard.changeRemainingBalance(mapSender);
        new HistoryBillImpl().insertHistoryBill(new Bill(Integer.parseInt(sender), Integer.parseInt(payee), Double.parseDouble(money), BussinessType.TRANSFER.toString()));
        return "Transfer successful";
    }

    @RequestMapping("/addBankCard")
    public String addBankCard(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        System.out.println("Received a request to add a bank card, ID: " + userId);
        String newPassword = httpServletRequest.getParameter("newPassword");
        String addBankCardNumber = httpServletRequest.getParameter("addBankCardNumber");
        String bank = httpServletRequest.getParameter("bank");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", userId);
        map.put("bankcardnumber", addBankCardNumber);
        new UserBankCardImpl().addBankCard(map);
        new BankCardImpl().addBankCard(new BankCard(Integer.parseInt(addBankCardNumber), newPassword, 0, bank));
        return "Bank card added successfully";
    }

    @RequestMapping("/getLoanMoney")
    public String getLoanMoney(HttpServletRequest httpServletRequest) {
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute("loginUserId"));
        String bankcardNumber = httpServletRequest.getParameter("bankcardNumber");
        String money = httpServletRequest.getParameter("money");
        System.out.println("Received a loan request, ID: " + userId + ", card number: " + bankcardNumber + ", amount: " + money);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bankcardNumber", bankcardNumber);
        map.put("number", Double.parseDouble(money));
        new BankCardImpl().changeRemainingBalance(map);
        Bill bill = new Bill();
        bill.setpayee(userId);
        bill.settype(BussinessType.LOAN.toString());
        bill.setvalue(Double.parseDouble(money));
        new HistoryBillImpl().insertHistoryDepositBill(bill);
        return "Loan successful";
    }
}