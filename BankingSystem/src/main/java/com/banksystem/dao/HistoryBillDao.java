package com.banksystem.dao;

import com.banksystem.pojo.Bill;
import com.banksystem.pojo.HistoryBill;

import java.util.List;

/**
 * description: HistoryBillDao <br>
 * version: 1.0 <br>
 */
public interface HistoryBillDao {
    List<HistoryBill> getHistoryBillList();
    List<HistoryBill>getHistoryBillListById(int id);
    void insertHistoryBill(Bill bill);
    void insertHistoryWithdrawBill(Bill bill);
    void insertHistoryDepositBill(Bill bill);
    void deleteHistoryBill(Bill bill);
}
