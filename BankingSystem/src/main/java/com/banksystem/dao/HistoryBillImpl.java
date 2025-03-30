package com.banksystem.dao;

import com.banksystem.pojo.Bill;
import com.banksystem.pojo.HistoryBill;
import com.banksystem.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * description: HistoryBillImpl <br>
 * version: 1.0 <br>
 */
public class HistoryBillImpl implements HistoryBillDao {

    @Override
    public List<HistoryBill> getHistoryBillList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            return sqlSession.selectList("dao.com.banksystem.HistoryBillDao.getHistoryBillList");

        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<HistoryBill> getHistoryBillListById(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            HistoryBillDao historyBillDao = sqlSession.getMapper(HistoryBillDao.class);
            return historyBillDao.getHistoryBillListById(id);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void insertHistoryBill(Bill bill) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            HistoryBillDao historyBillDao = sqlSession.getMapper(HistoryBillDao.class);
            historyBillDao.insertHistoryBill(bill);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    public void insertHistoryWithdrawBill(Bill bill) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            HistoryBillDao historyBillDao = sqlSession.getMapper(HistoryBillDao.class);
            historyBillDao.insertHistoryWithdrawBill(bill);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    public void insertHistoryDepositBill(Bill bill) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            HistoryBillDao historyBillDao = sqlSession.getMapper(HistoryBillDao.class);
            historyBillDao.insertHistoryDepositBill(bill);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Override
    public void deleteHistoryBill(Bill bill) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.getSqlSession();
            HistoryBillDao historyBillDao = sqlSession.getMapper(HistoryBillDao.class);
            historyBillDao.deleteHistoryBill(bill);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
