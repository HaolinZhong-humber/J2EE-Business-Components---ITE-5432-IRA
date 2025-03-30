package com.banksystem.dao;

import com.banksystem.pojo.Loan;
import com.banksystem.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * description: LoanImpl <br>
 * version: 1.0 <br>
 */
public class LoanImpl implements LoanDao {
    @Override
    public List<Loan> getLoan() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            LoanDao loanDao = sqlSession.getMapper(LoanDao.class);
            return loanDao.getLoan();
        }finally {
            sqlSession.close();
        }
    }
}
