package com.dev9.dataexample.controller;


import com.dev9.dataexample.entity.Sprocket;
import com.dev9.dataexample.repo.SprocketRepository;
import com.google.common.collect.Lists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SprocketController {

    @Autowired
    SprocketRepository sprocketRepository;

    @RequestMapping(value = "/sprockets/", method = {RequestMethod.GET})
    public List<Sprocket> getSprockets() {
        return Lists.newArrayList(sprocketRepository.findAll());
    }

    @RequestMapping(value = "/sprockets/brand/{brand}", method = {RequestMethod.GET})
    public List<Sprocket> getSprockets(@PathVariable("brand") String brand) {
        return sprocketRepository.findByBrand(brand);
    }

    @RequestMapping(value = "/sprockets/", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void newSprocket(@RequestBody Sprocket sprocket) {
        sprocketRepository.save(sprocket);
    }

    @RequestMapping(value = "/sprockets/sku/{sku}", method = {RequestMethod.GET})
    public Sprocket getSprocketBySku(@PathVariable("sku") String sku) {
        return sprocketRepository.findBySku(sku);
    }
    
    @RequestMapping(value = "/sprockets/sku/{sku}", method = {RequestMethod.DELETE})
    public void deleteSprocketBySku(@PathVariable("sku") String sku) {
    	Sprocket sprocket = sprocketRepository.findBySku(sku);
    	if (sprocket == null) {
    		throw new ResourceNotFoundException("SKU "  + sku + " not Found.");
    	}
    	long id = sprocket.getId();
        sprocketRepository.delete(id);
    }
}
