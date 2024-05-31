package com.skintrading.skinhub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skintrading.skinhub.model.BaseGun;

@Repository
public interface BaseGunRepository extends CrudRepository<BaseGun, Long> {

}
