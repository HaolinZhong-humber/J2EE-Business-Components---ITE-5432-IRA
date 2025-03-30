package com.banksystem.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class InsertDataTests {
    InsertData insertData = new InsertData();

    @Test
    public void insertIntoDatabaseTest() throws IOException {
        insertData.insertIntoDatabase();
    }

    @Test
    public void insertIntoUserTest() throws IOException {
        insertData.insertIntoUser();
    }

    @Test
    public void insertIntoBillTest() throws IOException {
        insertData.insertIntoBill();
    }

    @Test
    public void insertIntoBankcard() throws IOException {
        insertData.insertIntoBankcardAndUserBandcard();
    }
}
