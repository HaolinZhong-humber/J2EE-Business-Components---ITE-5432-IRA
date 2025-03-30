package com.banksystem.dao;

import com.banksystem.pojo.BankCard;
import com.banksystem.pojo.BankCardManage;

import java.util.List;
import java.util.Map;

/**
 * description: BankCarkDao <br>
 * version: 1.0 <br>
 */
public interface BankCardDao {
    List<BankCardManage> getUserBankCard();

    List<BankCardManage> getBankCardById(int id);

    void addBankCard(BankCard bankCard);

    void deleteBankCard(int bankcardnumber);

    void changeInformation(Map<String, Object> map);

    void changeRemainingBalance(Map<String, Object> map);
}
