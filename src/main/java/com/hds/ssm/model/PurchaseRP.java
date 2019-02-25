package com.hds.ssm.model;

public class PurchaseRP {
    public Integer getPurchaseCount() {
        return PurchaseCount;
    }

    public void setPurchaseCount(Integer purchaseCount) {
        PurchaseCount = purchaseCount;
    }

    Integer PurchaseCount;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    Integer month;
}
