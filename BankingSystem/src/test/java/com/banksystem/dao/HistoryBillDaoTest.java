package com.banksystem.dao;

import com.banksystem.pojo.Bill;
import com.banksystem.pojo.BussinessType;
import com.banksystem.pojo.HistoryBill;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * description: HistoryBillDaoTest <br>
 * date: 2021/8/10 16:40 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class HistoryBillDaoTest {
    HistoryBillImpl historyBill = new HistoryBillImpl();

    @Test
    public void getHistoryBillTest() {
        List<HistoryBill> list = historyBill.getHistoryBillList();
        for (HistoryBill bill : list) {
            System.out.println(bill);
        }
    }


    @Test
    public void getHistoryBillListByIdTest() {
        List<HistoryBill> list = historyBill.getHistoryBillListById(123);
        for (HistoryBill bill : list) {
            System.out.println(bill);
        }
    }

    @Test
    public void insertHistoryBillTest() {
        historyBill.insertHistoryBill(new Bill(100, 102, 12.3, "转账"));
        historyBill.insertHistoryBill(new Bill(102, 100, 12.3, "取款"));


    }

    @Test
    public void insertHistoryWithdrawBill() {
        Bill bill = new Bill();
        bill.setsender(100);
        bill.setvalue(1234.234);
        bill.settype(BussinessType.取款.toString());
        historyBill.insertHistoryWithdrawBill(bill);
    }

    @Test
    public void insertHistoryDepositBill() {
        Bill bill = new Bill();
        bill.setpayee(100);
        bill.settype(BussinessType.存款.toString());
        bill.setvalue(123.12);
        historyBill.insertHistoryDepositBill(bill);

    }

    @Test
    public void deleteHistoryBill() {
        historyBill.deleteHistoryBill(new Bill(100, 137, 577899, "转账"));
//        historyBill.deleteHistoryBill(new Bill(102, 100, 12.3, "取款"));
//        Bill bill1 = new Bill();
//        bill1.setpayee(100);
//        bill1.settype(BussinessType.存款.toString());
//        bill1.setvalue(123.12);
//        historyBill.deleteHistoryBill(bill1);
//        Bill bill2 = new Bill();
//        bill2.setsender(100);
//        bill2.setvalue(1234.234);
//        bill2.settype(BussinessType.取款.toString());
//        historyBill.deleteHistoryBill(bill2);
    }
}
