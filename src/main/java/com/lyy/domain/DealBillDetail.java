package com.lyy.domain;

public class DealBillDetail {
    private String dt;
    private double maxPay;
    private double minPay;
    private double avgPay;
    private long userId;
    private String customTime;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public double getMaxPay() {
        return maxPay;
    }

    public void setMaxPay(double maxPay) {
        this.maxPay = maxPay;
    }

    public double getMinPay() {
        return minPay;
    }

    public void setMinPay(double minPay) {
        this.minPay = minPay;
    }

    public double getAvgPay() {
        return avgPay;
    }

    public void setAvgPay(double avgPay) {
        this.avgPay = avgPay;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCustomTime() {
        return customTime;
    }

    public void setCustomTime(String customTime) {
        this.customTime = customTime;
    }
}
