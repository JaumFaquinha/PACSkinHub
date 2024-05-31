package com.skintrading.skinhub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skintrading.skinhub.model.Transaction;

@Repository
public interface TransacitonRepository extends CrudRepository<Transaction, Long> {

}
