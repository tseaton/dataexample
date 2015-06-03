package com.dev9.dataexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sprocket implements Serializable {

    private static final long serialVersionUID = -2952735933715107252L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String description;

    @Column(unique=true)
    private String sku;

    private String brand;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
