package com.skintrading.skinhub.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skintrading.skinhub.dao.PersonRepository;
import com.skintrading.skinhub.dao.SkinRepository;
import com.skintrading.skinhub.dao.TransactionRepository;
import com.skintrading.skinhub.model.Person;
import com.skintrading.skinhub.model.Transaction;
import com.skintrading.skinhub.model.Skin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("service/transaction")
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SkinRepository skinRepository;

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(){

        List<Transaction> transactionList = (List<Transaction>)transactionRepository.findAll();
    
        if(transactionList == null || transactionList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(transactionList);
    }
        
    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id){
        
        Optional<Transaction> optTransaction = transactionRepository.findById(id);

        if(optTransaction.isEmpty()){
            String msg = "Transaction(" + id + ") was not found!";
            throw new RuntimeException(msg);
        }

        return optTransaction.get();
    }

    @GetMapping("/buyer{buyerId}")
    public List<Transaction> getTransactionByBuyerId(@PathVariable Long buyerId) {

        List<Transaction> transactions = transactionRepository.findByBuyerId(buyerId);

        if(transactions.isEmpty()){
            String msg = "Transaction with Buyer(" + buyerId + ") was not found!";
            throw new RuntimeException(msg);
        }

        return transactions;
    }
    
    @GetMapping("/seller{sellerId}")
    public List<Transaction> getTransactionBySellerId(@PathVariable Long sellerId) {

        List<Transaction> transactions = transactionRepository.findBySellerId(sellerId);

        if(transactions.isEmpty()){
            String msg = "Transaction with Buyer(" + sellerId + ") was not found!";
            throw new RuntimeException(msg);
        }

        return transactions;
    }

    @GetMapping("/skin{skinId}")
    public List<Transaction> getTransactionBySkinId(@PathVariable Long skinId) {

        List<Transaction> transactions = transactionRepository.findByBuyerId(skinId);

        if(transactions.isEmpty()){
            String msg = "Transaction with Skin(" + skinId + ") was not found!";
            throw new RuntimeException(msg);
        }

        return transactions;
    }


    @PostMapping("/{buyerId}/{sellerId}/{skinId}/{amount}")
    public ResponseEntity<Transaction> createTransaction(@PathVariable Long buyerId, @PathVariable Long sellerId, @PathVariable Long skinId, @PathVariable Long amount) {
        
        Transaction newTransaction = new Transaction();
        
        newTransaction.setBuyer(personRepository.findById(buyerId).get());
        newTransaction.setSeller(personRepository.findById(sellerId).get());
        newTransaction.setSkin(skinRepository.findById(skinId).get());
        newTransaction.setTransactionTime(LocalDateTime.now());
        newTransaction.setAmount(amount);

        Transaction createdTransaction = transactionRepository.save(newTransaction);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction updatedTransaction) {
        
        Optional<Transaction> optTransaction = transactionRepository.findById(id);

        if(optTransaction.isPresent()){
            
            Transaction transaction = optTransaction.get();

            Person buyer = updatedTransaction.getBuyer();
            Person seller = updatedTransaction.getSeller();

            Skin skin = updatedTransaction.getSkin();

            transaction.setBuyer(personRepository.findById(buyer.getId()));
            transaction.setSeller(personRepository.findById(seller.getId()));
            transaction.setSkin(skinRepository.findById(skin.getId()).get());
            transaction.setAmount(updatedTransaction.getAmount());
            transaction.setTransactionTime(updatedTransaction.getTransactionTime());

            Transaction newTransaction = transactionRepository.save(transaction);

            return ResponseEntity.ok(newTransaction);
        }else{
            return ResponseEntity.notFound().build();
        }        
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id){

        Optional<Transaction> optTransaction = transactionRepository.findById(id);

        if(optTransaction.isPresent()){
            transactionRepository.delete(optTransaction.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
 