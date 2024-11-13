package com.demirel.ecommerce.controller;

import com.demirel.ecommerce.dto.ShopDTO;
import com.demirel.ecommerce.entity.Shop;
import com.demirel.ecommerce.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Shop>> getAllShops(){
        return ResponseEntity.ok(shopService.getAllShops());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Long id){
        return ResponseEntity.ok(shopService.getShopById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Shop> addShop(@RequestBody ShopDTO shopDto){
        return ResponseEntity.ok(shopService.addShop(shopDto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Shop> deleteShop(@PathVariable Long id){
        return ResponseEntity.ok(shopService.deleteShopById(id));
    }
}
