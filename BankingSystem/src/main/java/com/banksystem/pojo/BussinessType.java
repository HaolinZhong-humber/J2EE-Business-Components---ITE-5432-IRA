package com.banksystem.pojo;

/**
 * description: BussinessType <br>
 * version: 1.0 <br>
 */

import java.util.Random;

public enum BussinessType {
    DEPOSIT, WITHDRAWAL, TRANSFER, LOAN;

    public static BussinessType getRandomly() {
        Random random = new Random();
        return BussinessType.values()[random.nextInt(BussinessType.values().length)];
    }

    @Override
    public String toString() {
        return super.toString();
    }
}