package com.skintrading.skinhub;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skintrading.skinhub.model.Person;
import com.skintrading.skinhub.model.Skin;
import com.skintrading.skinhub.model.Transaction;
import com.skintrading.skinhub.dao.PersonRepository;
import com.skintrading.skinhub.dao.SkinRepository;
import com.skintrading.skinhub.dao.TransactionRepository;

@SpringBootTest
public class TransactionTest {

    @Autowired
    private TransactionRepository transacitonRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SkinRepository skinRepository;

    @Test
    public void TransactionSaveTest(){

        Transaction transaction = new Transaction();

        LocalDateTime dateTime = LocalDateTime.now();
        
        // List<Person> buyers = personRepository.findByName("João");
        // List<Person> sellers = personRepository.findByName("Vinicius");

        Person seller = new Person();
        seller.setName("João");
        seller.setEmail("joaoteste@email.com.br");
        seller.setPassword("senha");        
        personRepository.save(seller);
        assertNotNull(seller.getId());

        Person buyer = new Person();
        buyer.setName("Vinicius");
        buyer.setEmail("viniciusteste@email.com");
        buyer.setPassword("senha123");
        personRepository.save(buyer);
        assertNotNull(buyer.getId());
        
        transaction.setBuyer(buyer);
        transaction.setSeller(seller);

        Skin skin = new Skin();
        skin.setName("Skin Aleatoria");
        skin.setPrice(100.00);
        skin.setSkinMarketLink("linkAletório");
        skin.setWearValue(skin.getWearValue());
        skinRepository.save(skin);
        assertNotNull(skin.getId());

        // List<Skin> skins = skinRepository.findByName("Aleatoria");   
        
        transaction.setSkin(skin);
        transaction.setAmount(1);
        transaction.setTransactionTime(dateTime);
        transacitonRepository.save(transaction);
        assertNotNull(transaction);
    }
}
