package com.skintrading.skinhub.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.skintrading.skinhub.model.Skin;

@Repository
public interface SkinRepository extends CrudRepository<Skin, Long>, PagingAndSortingRepository<Skin, Long>,
        JpaSpecificationExecutor<Skin> {

    @Query(value = "SELECT s.* FROM SKIN s WHERE s.NAME LIKE ':name %'", nativeQuery = true)
    List<Skin> findBySkinName(String name);

    List<Skin> findByPrice(float price);

}
