package com.banksystem.pojo;

/**
 * description: Bill <br>
 * version: 1.0 <br>
 */

public class Bill {
    protected int sender;
    protected int payee;
    protected double value;
    protected String type;

    public Bill() {
    }

    public Bill(int sender, int payee, double value, String type) {
        this.sender = sender;
        this.payee = payee;
        this.value = value;
        this.type = type;
    }

    public Bill(int sender, double value, String type) {
        this.sender = sender;
        this.value = value;
        this.type = type;
    }


    public int getsender() {
        return sender;
    }

    public void setsender(int sender) {
        this.sender = sender;
    }

    public int getpayee() {
        return payee;
    }

    public void setpayee(int payee) {
        this.payee = payee;
    }

    public double getvalue() {
        return value;
    }

    public void setvalue(double value) {
        this.value = value;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Bill{" +
                "sender=" + sender +
                ", payee=" + payee +
                ", value=" + value +
                ", type='" + type + '\'' +
                '}';
    }
}
