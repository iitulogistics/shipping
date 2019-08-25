package com.shipping.shipping.controllers;

import com.shipping.shipping.services.ProductTypeService;
import com.shipping.shipping.services.impl.DefaultProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productType")
public class ProductTypeController {
    private ProductTypeService typeService;

    @Autowired(required = false)
    @Qualifier("defaultProductTypeService")
    public void setProductTypeService(ProductTypeService productTypeService) {
        this.typeService = productTypeService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(typeService.getProductTypes());
    }

    @GetMapping("getProductTypeById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.getProductTypeById(id));
    }

    @PostMapping("addProductType")
    public ResponseEntity<?> addProductType(@RequestParam String type,
                                            @RequestParam String addInfo) {
        return ResponseEntity.ok(typeService.addProductType(type, addInfo));
    }

    @PatchMapping("updateProductType")
    public ResponseEntity<?> updateProductType(@RequestParam Long id,
                                               @RequestParam String type,
                                               @RequestParam String addInfo) {
        return ResponseEntity.ok(typeService.updateProductTypeById(id, type, addInfo));
    }

    @DeleteMapping("deleteProductTypeById")
    public ResponseEntity<?> deleteProductTypeById(@RequestParam Long id){
        return ResponseEntity.ok(typeService.deleteProductTypeById(id));
    }
}
