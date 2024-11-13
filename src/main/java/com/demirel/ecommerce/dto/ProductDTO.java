package com.demirel.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private String productName;
    private Double productPrice;
    private Short categoryId;
    private Long shopId;
}
