package com.banksystem.dao;

import com.banksystem.pojo.Loan;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * description: LoanDaoTest <br>
 * date: 2021/8/15 23:49 <br>
 * author: MYX <br>
 * version: 1.0 <br>
 */
public class LoanDaoTest {
    LoanImpl loanImpl=new LoanImpl();
    @Test
    public void getLoanTest(){
       List<Loan> list= loanImpl.getLoan();
        for (Loan loan : list) {
            System.out.println(loan);
        }
    }
}
