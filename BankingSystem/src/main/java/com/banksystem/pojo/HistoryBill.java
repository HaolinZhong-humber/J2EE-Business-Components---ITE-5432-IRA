package com.banksystem.pojo;

import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * description: HistoryBill <br>
 * version: 1.0 <br>
 */
public class HistoryBill extends Bill {
    String SenderName;
    String PayeeName;

    public String getSenderName() {
        return SenderName;
    }

    public void setSenderName(String senderName) {
        SenderName = senderName;
    }

    @Override
    public String toString() {
        return "HistoryBill{" +
                "sender=" + sender +
                ", payee=" + payee +
                ", value=" + value +
                ", type='" + type + '\'' +
                "SenderName='" + SenderName + '\'' +
                ", PayeeName='" + PayeeName + '\'' +
                '}';
    }

    public String getPayeeName() {
        return PayeeName;
    }

    public void setPayeeName(String payeeName) {
        PayeeName = payeeName;
    }

    public HistoryBill() {
    }

    public HistoryBill(@Nullable int sender,@Nullable int payee, double value, String type,@Nullable String senderName,@Nullable String payeeName) {
        super(sender, payee, value, type);
        SenderName = senderName;
        PayeeName = payeeName;
    }

    public Collection<HistoryBill> some() {
        Random random = new Random();

        Collection<HistoryBill> result = new ArrayList<HistoryBill>();
        result.add(new HistoryBill(random.nextInt(1000000), random.nextInt(1000000), random.nextDouble() * 1000000, BussinessType.getRandomly().toString(), "张三丰", "白居易"));
        result.add(new HistoryBill(random.nextInt(1000000), random.nextInt(1000000), random.nextDouble() * 1000000, BussinessType.getRandomly().toString(), "张三丰", "白居易"));
        result.add(new HistoryBill(random.nextInt(1000000), random.nextInt(1000000), random.nextDouble() * 1000000, BussinessType.getRandomly().toString(), "张三丰", "白居易"));
        result.add(new HistoryBill(random.nextInt(1000000), random.nextInt(1000000), random.nextDouble() * 1000000, BussinessType.getRandomly().toString(), "张三丰", "白居易"));
        result.add(new HistoryBill(random.nextInt(1000000), random.nextInt(1000000), random.nextDouble() * 1000000, BussinessType.getRandomly().toString(), "张三丰", "白居易"));
        result.add(new HistoryBill(random.nextInt(1000000), random.nextInt(1000000), random.nextDouble() * 1000000, BussinessType.getRandomly().toString(), "张三丰", "白居易"));
        result.add(new HistoryBill(random.nextInt(1000000), random.nextInt(1000000), random.nextDouble() * 1000000, BussinessType.getRandomly().toString(), "张三丰", "白居易"));
        result.add(new HistoryBill(random.nextInt(1000000), random.nextInt(1000000), random.nextDouble() * 1000000, BussinessType.getRandomly().toString(), "张三丰", "白居易"));

        return result;
    }
}
