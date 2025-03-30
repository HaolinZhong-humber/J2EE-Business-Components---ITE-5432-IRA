package com.banksystem.pojo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * description: BankCardManage <br>
 * version: 1.0 <br>
 */
public class BankCardManage {

    private String userName;
    private Bank bank;
    private int bankCardNumber;
    private int userId;
    private double remainingBalance;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(int bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public BankCardManage(String userName, Bank bank, int bankCardNumber, int userId, double remainingBalance) {
        this.userName = userName;
        this.bank = bank;
        this.bankCardNumber = bankCardNumber;
        this.userId = userId;
        this.remainingBalance = remainingBalance;
    }



    public BankCardManage() {
    }

    @Override
    public String toString() {
        return "BankCardManage{" +
                "userName='" + userName + '\'' +
                ", bank=" + bank +
                ", bankCardNumber=" + bankCardNumber +
                ", userId=" + userId +
                ", remainingBalance=" + remainingBalance +
                '}';
    }

    public Collection<BankCardManage> some() {
        Collection<BankCardManage> collections = new ArrayList<BankCardManage>();
        collections.add(new BankCardManage("John", Bank.Barclays, 213414125, 12341234, 2134.5121));
        collections.add(new BankCardManage("Alice", Bank.Barclays, 213414125, 12341234, 2134.5121));
        collections.add(new BankCardManage("Bob", Bank.Barclays, 213414125, 12341234, 2134.5121));
        return collections;
    }
}
