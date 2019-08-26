package com.shipping.shipping.services.impl;

import com.shipping.shipping.entities.ProductEntity;
import com.shipping.shipping.entities.ProductTypeEntity;
import com.shipping.shipping.repositories.ProductRepository;
import com.shipping.shipping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductService implements ProductService {
    private final ProductRepository repository;

    public DefaultProductService(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ProductEntity> getProducts() {
        return repository.findAll();
    }

    @Override
    public String addProduct(String product_name,
                             Long product_type,
                             Integer weight) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setWeight(weight);
        productEntity.setProductTypeId(product_type);
        productEntity.setProduct_name(product_name);

        repository.save(productEntity);
        return "Product is added";
    }

    @Override
    public String updateProductById(Long id,
                                    String product_name,
                                    Long product_type,
                                    Integer weight) {
        ProductEntity productEntity = repository.getOne(id);
        productEntity.setWeight(weight);
        productEntity.setProductTypeId(product_type);
        productEntity.setProduct_name(product_name);

        repository.save(productEntity);
        return "Product is updated";
    }

    @Override
    public String deleteProductById(Long id) {
        repository.deleteById(id);
        return "Product is deleted";
    }
}
