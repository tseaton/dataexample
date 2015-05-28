package com.dev9.dataexample.util;

import com.dev9.dataexample.entity.Sprocket;
import com.dev9.dataexample.repo.SprocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class SprocketLoader {

    @Autowired
    private SprocketRepository sprocketRepository;

    @PostConstruct
    public void initialize() {
        loadSpacelySprockets("Spacely", 10, "Sprocket-412g");
        loadSpacelySprockets("Cogsworth", 5, "Sprocko-Cog54");
    }

    private void loadSpacelySprockets(String brand, int size, String description) {
        for(int i=0; i < size; i++) {
            Sprocket sprocket = new Sprocket();
            sprocket.setSku(UUID.randomUUID().toString());
            sprocket.setBrand(brand);
            sprocket.setDescription(brand + " "+description);
            sprocketRepository.save(sprocket);
        }
    }
}
