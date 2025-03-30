package com.banksystem.pojo;

/**
 * description: BankCard <br>
 * version: 1.0 <br>
 */
public class BankCard {

    int bankcardnumber;
    String password;
    double remaining_balance;
    String bank_name;
    public int getBankcardnumber() {
        return bankcardnumber;
    }

    public void setBankcardnumber(int bankcardnumber) {
        this.bankcardnumber = bankcardnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRemaining_balance() {
        return remaining_balance;
    }

    public void setRemaining_balance(double remaining_balance) {
        this.remaining_balance = remaining_balance;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public BankCard() {
    }

    public BankCard(int bankcardnumber, String password, double remaining_balance, String bank_name) {
        this.bankcardnumber = bankcardnumber;
        this.password = password;
        this.remaining_balance = remaining_balance;
        this.bank_name = bank_name;
    }


}
