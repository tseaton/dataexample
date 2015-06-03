package com.dev9.dataexample.repo;


import com.dev9.dataexample.entity.Sprocket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SprocketRepository extends CrudRepository<Sprocket, Long> {

    Sprocket findBySku(String sku);
    List<Sprocket> findByBrand(String brand);
    
    void deleteBySku(String sku);
}
