package com.dev9.dataexample.controller;


import com.dev9.dataexample.entity.Sprocket;
import com.dev9.dataexample.repo.SprocketRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class SprocketController {

    @Autowired
    SprocketRepository sprocketRepository;

    @ResponseBody
    @RequestMapping(value = "/sprockets/", method = {RequestMethod.GET})
    public List<Sprocket> getSprockets() {
        return Lists.newArrayList(sprocketRepository.findAll());
    }

    @ResponseBody
    @RequestMapping(value = "/sprockets/{sku}", method = {RequestMethod.GET})
    public Sprocket getSprocketBySku(@PathVariable("sku") String sku) {
        return sprocketRepository.findBySku(sku);
    }

    @RequestMapping(value = "/sprockets/", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void newSprocket(@RequestBody Sprocket sprocket) {
        sprocketRepository.save(sprocket);
    }

}
