package com.skintrading.skinhub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skintrading.skinhub.model.Transaction;
import com.skintrading.skinhub.model.Person;

import java.util.List;


@Repository
public interface TransacitonRepository extends CrudRepository<Transaction, Long> {

    // @Query(value = "SELECT * FROM Transaction t WHERE t.seller_id = :seller_id")
    // public List<Transaction> findSeller(int seller_id);

    // @Query(value = "SELECT * FROM Transaction t WHERE t.buyer_id = :buyer_id")
    // public List<Transaction> findBuyer(int buyer_id);

    List<Transaction> findBySeller(Person seller);
    List<Transaction> findByBuyer(Person buyer);
    
    // @Query(value = "SELECT * FROM Transaction as t WHERE t.seller_id = :seller_id  AND t.buyer_id = :buyer_id" )
    // List<Transaction> findSellerBuyer(int buyer_id, int seller_id);
}
