package com.skintrading.skinhub.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skintrading.skinhub.model.Transaction;

import java.util.List;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    // @Query(value = "SELECT * FROM Transaction t WHERE t.seller_id = :seller_id")
    // public List<Transaction> findSeller(int seller_id);

    // @Query(value = "SELECT * FROM Transaction t WHERE t.buyer_id = :buyer_id")
    // public List<Transaction> findBuyer(int buyer_id);
    List<Transaction> findById(long id);

    @Query(value = "SELECT * FROM Transaction t WHERE t.buyer_id = :buyer", nativeQuery = true)
    List<Transaction> findByBuyerId(long buyer);    

    @Query(value = "SELECT * FROM Transaction t WHERE t.buyer_id = :seller", nativeQuery = true)
    List<Transaction> findBySellerId(long seller);
    
    @Query(value = "SELECT * FROM Transaction t WHERE t.skin_id = :skin", nativeQuery = true)
    List<Transaction> findBySkinId(long skin);

    // @Query(value = "SELECT * FROM Transaction as t WHERE t.seller_id = :seller_id  AND t.buyer_id = :buyer_id" )
    // List<Transaction> findSellerBuyer(int buyer_id, int seller_id);
}
