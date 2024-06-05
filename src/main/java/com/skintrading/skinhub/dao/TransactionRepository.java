package com.skintrading.skinhub.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skintrading.skinhub.model.Transaction;

import java.util.List;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    
    List<Transaction> findById(long id);

    @Query(value = "SELECT * FROM Transaction t WHERE t.buyer_id = :buyer", nativeQuery = true)
    List<Transaction> findByBuyerId(long buyer);    

    @Query(value = "SELECT * FROM Transaction t WHERE t.buyer_id = :seller", nativeQuery = true)
    List<Transaction> findBySellerId(long seller);
    
    @Query(value = "SELECT * FROM Transaction t WHERE t.skin_id = :skin", nativeQuery = true)
    List<Transaction> findBySkinId(long skin);

    @Query(value = "SELECT * FROM Transaction as t WHERE t.seller_id = :sellerId  AND t.buyer_id = :buyerId", nativeQuery = true )
    List<Transaction> findSellerBuyerId(long buyerId, long sellerId);
}
