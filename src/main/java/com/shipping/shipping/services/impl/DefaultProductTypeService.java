package com.shipping.shipping.services.impl;

import com.shipping.shipping.entities.ProductTypeEntity;
import com.shipping.shipping.repositories.ProductTypeRepository;
import com.shipping.shipping.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class DefaultProductTypeService implements ProductTypeService {

    private ProductTypeRepository repository;

    @Autowired(required = false)
    public void setProductTypeRepository(ProductTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductTypeEntity getProductTypeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ProductTypeEntity> getProductTypes() {
        return repository.findAll();
    }

    @Override
    public String addProductType(String type, String addInfo) {
        ProductTypeEntity productTypeEntity = new ProductTypeEntity();
        productTypeEntity.setType(type);
        productTypeEntity.setAddInfo(addInfo);
        repository.save(productTypeEntity);
        return "ProductType is added";
    }

    @Override
    public String updateProductTypeById(Long id,
                                        String type,
                                        String addInfo) {
        ProductTypeEntity entity = repository.getOne(id);
        entity.setType(type);
        entity.setAddInfo(addInfo);

        repository.save(entity);
        return "ProductType is updated";
    }

    @Override
    public String deleteProductTypeById(Long id) {
        repository.deleteById(id);
        return "ProductType with id = " + id + " is deleted";
    }
}
