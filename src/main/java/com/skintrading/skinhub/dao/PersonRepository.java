package com.skintrading.skinhub.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.skintrading.skinhub.model.Person;;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>, PagingAndSortingRepository<Person, Long>,
        JpaSpecificationExecutor<Person> {

    List<Person> findByName(String name);

}
