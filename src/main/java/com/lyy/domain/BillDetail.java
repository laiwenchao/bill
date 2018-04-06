package com.lyy.domain;

import java.sql.Timestamp;

public class BillDetail {
    private long id;
    private long userId;
    private String productName;
    private String description;
    private double payAccount;
    private String customTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(double payAccount) {
        this.payAccount = payAccount;
    }

    public String getCustomTime() {
        return customTime;
    }

    public void setCustomTime(String customTime) {
        this.customTime = customTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
