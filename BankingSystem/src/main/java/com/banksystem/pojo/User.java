package com.banksystem.pojo;
/**
 * description: User <br>
 * version: 1.0 <br>
 */

public class User {
    private int ID;
    private String phoneNumber;
    private String name;
    private String password;
    private String address;

    public User() {
    }

    public User(int ID, String password) {
        this.ID = ID;
        this.password = password;
    }

    public User(int ID, String phoneNumber, String name, String password, String address) {
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
