package com.banksystem.dao;

import java.util.Map;

/**
 * description: UserBankCardDao <br>
 * version: 1.0 <br>
 */
public interface UserBankCardDao {
    void addBankCard(Map<String, Object> map);
    void deleteBankCard(Map<String, Object> map);
}
