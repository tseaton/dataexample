package com.dev9.dataexample.repo;


import com.dev9.dataexample.entity.Sprocket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprocketRepository extends CrudRepository<Sprocket, Long> {

    Sprocket findBySku(@Param("sku") String sku);
    List<Sprocket> findByBrand(@Param("brand") String brand);

}
