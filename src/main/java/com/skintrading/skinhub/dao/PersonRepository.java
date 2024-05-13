package com.skintrading.skinhub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skintrading.skinhub.model.Person;;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>
{

}
