package com.skintrading.skinhub;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.skintrading.skinhub.model.Skin;
import com.skintrading.skinhub.dao.SkinRepository;

@SpringBootTest
public class SkinTest {
    
    @Autowired
    private SkinRepository skinRepository;

    @Test
    public void skinSaveTest(){

        Skin skin = new Skin();
        skin.setName("Skin Aleatoria");
        skin.setPrice(100.00);
        skin.setSkinMarketLink("linkAletório");
        skin.setWearValue(skin.getWearValue());
        skinRepository.save(skin);
        assertNotNull(skin.getId());

    }

}
