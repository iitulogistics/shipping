package com.shipping.shipping.services;

import com.shipping.shipping.entities.ProductTypeEntity;

import java.util.List;

public interface ProductTypeService {
    ProductTypeEntity getProductTypeById(Long id);

    List<ProductTypeEntity> getProductTypes();

    String addProductType(String type,
                          String addInfo);

    String updateProductTypeById(Long id,
                                 String type,
                                 String addInfo);

    String deleteProductTypeById(Long id);
}
