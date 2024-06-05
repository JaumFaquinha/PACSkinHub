package com.skintrading.skinhub.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skintrading.skinhub.dao.SkinRepository;
import com.skintrading.skinhub.model.Skin;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("service/skin")
public class SkinService {

    @Autowired
    SkinRepository skinRepository;

    @GetMapping()
    public ResponseEntity<List<Skin>> getSkins(Model model) {
        List<Skin> skinList = (List<Skin>)skinRepository.findAll();
        
        if(skinList == null || skinList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(skinList);
    }

    @GetMapping("/{id}")
    public Skin getSkinById(@PathVariable Long id) {
        
        Optional<Skin> result = skinRepository.findById(id);

        if(result.isEmpty()){
            String msg = "Skin(" + id + ") was not found!";
            throw new RuntimeException(msg);
        }

        return result.get();
    }




    //-----Rever-----
    // @GetMapping("/name/{name}")
    // public List<Skin> getSkinByName(@RequestParam String name) {
        
    //     List<Skin> result = skinRepository.findBySkinName(name);

    //     if(result.isEmpty()){
    //         String msg = "Skin(" + name + ") was not found!";
    //         throw new RuntimeException(msg);
    //     }
    //     return result;
    // }



    @PostMapping()
    public ResponseEntity<Skin> createSkin(@RequestBody Skin skin) {
        
        Skin newSkin = skinRepository.save(skin);

        return ResponseEntity.status(HttpStatus.CREATED).body(newSkin);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Skin> updateSkin(@PathVariable Long id, @RequestBody Skin updatedSkin) {
        
        Optional<Skin> optSkin = skinRepository.findById(id);

        if(optSkin.isPresent()){

            Skin skin = optSkin.get();

            skin.setName(updatedSkin.getName());
            skin.setEquipmentType(updatedSkin.getEquipmentType());
            skin.setPrice(updatedSkin.getPrice());
            skin.setSkinMarketLink(updatedSkin.getSkinMarketLink());
            skin.setWearLevel(updatedSkin.getWearLevel());
            skin.setWearValue(skin.getWearValue());
            
            Skin newSkin = skinRepository.save(skin);
            
            return ResponseEntity.ok(newSkin);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkin(@PathVariable Long id){

        Optional<Skin> optSkin = skinRepository.findById(id);
        
        if(optSkin.isPresent()){
            skinRepository.delete(optSkin.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }    
}
