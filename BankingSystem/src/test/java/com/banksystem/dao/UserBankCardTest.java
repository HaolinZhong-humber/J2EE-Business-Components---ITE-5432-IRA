package com.banksystem.dao;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * description: UserBankCardTest <br>
 * date: 2021/8/15 17:19 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class UserBankCardTest {

    UserBankCardImpl userBankCardImpl = new UserBankCardImpl();

    @Test
    public void addBankCardTest() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 100);
        map.put("bankcardnumber", 1234525);
        userBankCardImpl.addBankCard(map);
    }
    @Test
    public void deleteBankCardTest() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 123);
        map.put("bankcardnumber", 471051221);
        userBankCardImpl.deleteBankCard(map);
    }
}
