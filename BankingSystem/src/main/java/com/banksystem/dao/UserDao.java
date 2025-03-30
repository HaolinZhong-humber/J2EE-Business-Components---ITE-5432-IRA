package com.banksystem.dao;

import com.banksystem.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * description: UserDao <br>
 * version: 1.0 <br>
 */
public interface UserDao {
    List<User> getUserList();//获取全部用户；

    User getUserById(int id);//通过id查询用户

    String getUserNameById(int id);

    void changeInformation(User user);

    void changePassword(Map<String, Object> map);

    void changeName(Map<String, Object> map);

    void changeAddress(Map<String, Object> map);

    void changePhoneNumber(Map<String, Object> map);

    void addUser(User user);
    void deleteUser(int id);
}