package com.skintrading.skinhub.dto;

import java.time.LocalDateTime;

public class NewTransactionRequisition 
{
    long buyerId;
    long sellerId;
    long skinId;
    private LocalDateTime transactionTime;
    private double amount;


    public long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    public long getSellerId() {
        return sellerId;
    }
    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getSkinId() {
        return skinId;
    }
    public void setSkinId(long skinId) {
        this.skinId = skinId;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }
    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
    
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    

}
