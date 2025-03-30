package com.banksystem.util;

import com.banksystem.pojo.Bank;
import com.banksystem.pojo.BussinessType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InsertData {
    /**
     * @Title
     * @Description: Start all methods to write data into files
     **/
    public void insertIntoDatabase() throws IOException {
        insertIntoUser();
        insertIntoBill();
        insertIntoBankcardAndUserBandcard();
    }

    /**
     * @Title
     * @Description: Write insert statements for the user table into insertData.sql
     **/
    public void insertIntoUser() throws IOException {
        File file = new File(CommonVariables.sqlFilePath + "insertData.sql");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            RandomGenerate randomGenerate = new RandomGenerate();
            for (int i = 100; i < 150; i++) {
                String id = String.valueOf(i);
                String name = randomGenerate.chineseName();
                String address = randomGenerate.address();
                String phoneNumber = randomGenerate.phoneNumber();
                String insertWords = "insert into user(id,password,address,name,phone_number) values(" + id + ",\"" + id + "\"" + ",\"" + address + "\"" + ",\"" + name + "\"" + ",\"" + phoneNumber + "\"" + ");\r\n";
//                System.out.println(insertWords);
                bufferedWriter.write(insertWords);
                bufferedWriter.flush();
            }
            System.out.println("Successfully inserted insert statements for users with IDs and passwords from 100 to 150 into insertData.sql");
        } finally {
            fileWriter.close();
            bufferedWriter.close();
        }
    }

    /**
     * @Title
     * @Description: Write insert statements for the Bill table into insertData.sql
     **/
    public void insertIntoBill() throws IOException {
        File file = new File(CommonVariables.sqlFilePath + "insertData.sql");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Random random = new Random();
        try {
            for (int i = 100; i < 150; i++) {
                String senderID = String.valueOf(i);
                for (int t = 0; t < random.nextInt(25); t++) {
                    String payeeID = String.valueOf(random.nextInt(49) + 100);
                    String value = String.valueOf(random.nextInt(1000000));
                    BussinessType type = BussinessType.getRandomly();
                    String insertWords = null;
                    if (type == BussinessType.WITHDRAWAL) {
                        insertWords = "insert into bill(sender,value,type) values(" + senderID + "," + value + ",\"" + type + "\");\r\n";
                    }
                    if (type == BussinessType.DEPOSIT) {
                        insertWords = "insert into bill(payee,value,type) values(" + payeeID + "," + value + ",\"" + type + "\");\r\n";
                    }
                    if (type == BussinessType.TRANSFER) {
                        insertWords = "insert into bill(sender,payee,value,type) values(" + senderID + "," + payeeID + "," + value + ",\"" + type + "\");\r\n";
                    }
                    if (type == BussinessType.LOAN) {
                        insertWords = "insert into bill(payee,value,type) values(" + payeeID + "," + value + ",\"" + type + "\");\r\n";
                    }
                    bufferedWriter.write(insertWords);
                    bufferedWriter.flush();

                }
            }
            System.out.println("Successfully inserted insert statements for the Bill table into insertData.sql");
        } finally {
            fileWriter.close();
            bufferedWriter.close();
        }
    }

    /**
     * @Title
     * @Description: Write insert statements for the BankCard and UserBankCard tables into insertData.sql
     **/
    public void insertIntoBankcardAndUserBandcard() throws IOException {
        File file = new File(CommonVariables.sqlFilePath + "insertData.sql");
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Random random = new Random();
        try {
            for (int i = 100; i < 150; i++) {
                for (int t = 0; t < random.nextInt(20); t++) {
                    String bankCardNumber = String.valueOf(random.nextInt(1000000000) + 100000000);
                    Bank bankName = Bank.getRandomly();
                    int value = random.nextInt(1000000);
                    String insertWord = "insert into BANKCARD(BANKCARDNUMBER,PASSWORD,remaining_balance,BANK_NAME) values(" + bankCardNumber + ",\"111111\"," + value + ",\"" + bankName + "\");\r\n";
                    bufferedWriter.write(insertWord);
                    String userID = String.valueOf(i);
                    String insertWord2 = "insert into USER_BANKCARD(USERID,BANKCARDNUMBER) values(" + userID + "," + bankCardNumber + ");\r\n";
                    bufferedWriter.write(insertWord2);
                    bufferedWriter.flush();
//                    System.out.println(insertWord);
                }
            }
            System.out.println("Successfully inserted insert statements for the BankCard and UserBankCard tables into insertData.sql");
        } finally {
            fileWriter.close();
            bufferedWriter.close();
        }
    }
}