package com.skintrading.skinhub.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.skintrading.skinhub.model.Skin;

@Repository
public interface SkinRepository extends CrudRepository<Skin, Long>, PagingAndSortingRepository<Skin, Long>,
        JpaSpecificationExecutor<Skin> {
    List<Skin> findByName(String name);

    List<Skin> findByPrice(float price);

}
