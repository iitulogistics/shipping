package com.shipping.shipping.services;

import com.shipping.shipping.entities.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity getProductById(Long id);

    List<ProductEntity> getProducts();

    String addProduct(String product_name,
                      Long product_type,
                      Integer weight);

    String updateProductById(Long id,
                             String product_name,
                             Long product_type,
                             Integer weight);

    String deleteProductById(Long id);
}
