package com.demirel.ecommerce.service;

import com.demirel.ecommerce.dto.ProductDTO;
import com.demirel.ecommerce.entity.Category;
import com.demirel.ecommerce.entity.Product;
import com.demirel.ecommerce.entity.Shop;
import com.demirel.ecommerce.exception.CategoryNotFoundException;
import com.demirel.ecommerce.exception.ProductNotFoundException;
import com.demirel.ecommerce.exception.ShopNotFoundException;
import com.demirel.ecommerce.repository.CategoryRepository;
import com.demirel.ecommerce.repository.ProductCommentRepository;
import com.demirel.ecommerce.repository.ProductRepository;
import com.demirel.ecommerce.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    ShopRepository shopRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ShopRepository shopRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        } else{
            throw new ProductNotFoundException("Product ID that you entered does not exist!");
        }
    }

    @Override
    public Product addProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category ID that you entered does not exist!"));
        Shop shop = shopRepository.findById(productDTO.getShopId())
                .orElseThrow(()-> new ShopNotFoundException("Shop ID that you entered does not exist!"));
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setCategory(category);
        product.setShop(shop);
        return productRepository.save(product);
    }

    @Override
    public Product deleteProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return optionalProduct.get();
        } else{
            throw new ProductNotFoundException("Product ID that you entered does not exist!");
        }
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }
}
