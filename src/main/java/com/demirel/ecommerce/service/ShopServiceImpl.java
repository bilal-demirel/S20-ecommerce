package com.demirel.ecommerce.service;


import com.demirel.ecommerce.dto.ShopDTO;
import com.demirel.ecommerce.entity.Shop;
import com.demirel.ecommerce.entity.User;
import com.demirel.ecommerce.exception.ShopNotFoundException;
import com.demirel.ecommerce.exception.UserNotFoundException;
import com.demirel.ecommerce.repository.ShopRepository;
import com.demirel.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {
    ShopRepository shopRepository;
    UserRepository userRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, UserRepository userRepository){
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;
    }

    public List<Shop> getAllShops(){
        return shopRepository.findAll();
    }

    @Override
    public Shop getShopById(Long id) {
        Optional<Shop> optionalShop = shopRepository.findById(id);
        if(optionalShop.isPresent()){
            return optionalShop.get();
        } else {
            throw new ShopNotFoundException("Shop ID that you entered does not exist!");
        }
    }

    @Override
    public Shop addShop(ShopDTO shopDto) {
        User user = userRepository.findById(shopDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User ID that you entered not found!"));

        Shop shop = new Shop();
        shop.setShopName(shopDto.getShopName());
        shop.setUser(user);
        return shopRepository.save(shop);
    }

    @Override
    public Shop deleteShopById(Long id) {
        Optional<Shop> optionalShop = shopRepository.findById(id);
        if(optionalShop.isPresent()){
            shopRepository.deleteById(id);
            return optionalShop.get();
        } else {
            throw new ShopNotFoundException("Shop ID that you entered does not exist!");
        }
    }

    @Override
    public Shop updateShop(Shop shop) {
        return null;
    }

}
