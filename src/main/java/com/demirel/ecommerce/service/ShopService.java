package com.demirel.ecommerce.service;


import com.demirel.ecommerce.dto.ShopDTO;
import com.demirel.ecommerce.entity.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAllShops();
    Shop getShopById(Long id);
    Shop addShop(ShopDTO shopDto);
    Shop deleteShopById(Long id);
    Shop updateShop(Shop shop);
}
