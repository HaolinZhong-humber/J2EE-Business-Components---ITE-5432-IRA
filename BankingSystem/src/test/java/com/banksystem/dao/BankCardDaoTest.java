package com.banksystem.dao;

import com.banksystem.pojo.Bank;
import com.banksystem.pojo.BankCard;
import com.banksystem.pojo.BankCardManage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: BankCardDaoTest <br>
 * date: 2021/8/15 16:21 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class BankCardDaoTest {
    BankCardImpl bankCardImpl = new BankCardImpl();

    @Test
    public void getUserBankCard() {
        List<BankCardManage> list = bankCardImpl.getUserBankCard();
        for (BankCardManage bankCardManage : list) {
            System.out.println(bankCardManage);
        }
    }


    @Test
    public void getBankCardByIdTest() {
        List<BankCardManage> list = bankCardImpl.getBankCardById(100);
        for (BankCardManage bankCardManage : list) {
            System.out.println(bankCardManage);
        }
    }

    @Test
    public void addBankCardTest() {
        bankCardImpl.addBankCard(new BankCard(1234567, "12341", 134.234, Bank.Barclays.toString()));
    }

    @Test
    public void deleteBankCardTest() {
        bankCardImpl.deleteBankCard(1234567);
    }

    @Test
    void changeInformation() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("password", "111111");
        map.put("bankcardNumber", "101800680");
        bankCardImpl.changeInformation(map);
    }

    @Test
    void changeRemainingBalance() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("bankcardNumber", "101800680");
        map.put("number", -1000);
        bankCardImpl.changeRemainingBalance(map);
    }

}
