package com.banksystem.util;

import org.junit.jupiter.api.Test;

/**
 * description: ChineseNameTest <br>
 * date: 2021/8/16 14:05 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class RandomGenerateTest {
    RandomGenerate randomGenerate = new RandomGenerate();

    @Test
    public void getChineseNameTest() {

        for (int i = 0; i < 100; ++i) {
            System.out.println(randomGenerate.chineseName());
        }
    }

    @Test
    public void PhoneNumber() {
        for (int i = 0; i < 100; ++i) {
            System.out.println(randomGenerate.phoneNumber());
        }
    }

    @Test
    public void address() {
        for (int i = 0; i < 100; i++) {
            System.out.println(randomGenerate.address());
        }
    }
}
