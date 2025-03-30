package com.banksystem.pojo;

/**
 * description: Loan <br>
 * version: 1.0 <br>
 */
public class Loan {
    int id;
    double interestrate;
    String name;
    String detial;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", interestrate=" + interestrate +
                ", name='" + name + '\'' +
                ", detial='" + detial + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetial() {
        return detial;
    }

    public void setDetial(String detial) {
        this.detial = detial;
    }

    public Loan() {
    }

    public Loan(int id, double interestrate, String name, String detial) {
        this.id = id;
        this.interestrate = interestrate;
        this.name = name;
        this.detial = detial;
    }


}
