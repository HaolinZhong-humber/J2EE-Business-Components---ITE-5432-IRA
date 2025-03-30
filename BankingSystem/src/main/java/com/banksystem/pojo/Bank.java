package com.banksystem.pojo;

import java.util.Random;

/**
 * description: Bank <br>
 * version: 1.0 <br>
 */
public enum Bank {
    Barclays,
    LloydsBank,
    HSBC;

    public static Bank getRandomly() {
        Random random = new Random();
        return Bank.values()[random.nextInt(Bank.values().length)];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
