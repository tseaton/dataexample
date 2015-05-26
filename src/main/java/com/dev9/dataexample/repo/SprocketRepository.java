package com.dev9.dataexample.repo;


import com.dev9.dataexample.entity.Sprocket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprocketRepository extends CrudRepository<Sprocket, Long> {

    Sprocket findBySku(String sku);

}
