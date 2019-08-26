package com.shipping.shipping.controllers;

import com.shipping.shipping.services.ProductTypeService;
import com.shipping.shipping.services.impl.DefaultProductTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productType")
@Api(tags = "Список типов продукта", description = "Api для списка продукта")
public class ProductTypeController {
    private final ProductTypeService typeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.typeService = productTypeService;
    }

    @ApiOperation("Список типов продукта")
    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(typeService.getProductTypes());
    }

    @ApiOperation("Вернуть тип продукта по id")
    @GetMapping("getProductTypeById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.getProductTypeById(id));
    }

    @ApiOperation("Добавить тип продукта")
    @PostMapping("addProductType")
    public ResponseEntity<?> addProductType(@RequestParam String type,
                                            @RequestParam String addInfo) {
        return ResponseEntity.ok(typeService.addProductType(type, addInfo));
    }

    @ApiOperation("Обновить тип продукта")
    @PatchMapping("updateProductType")
    public ResponseEntity<?> updateProductType(@RequestParam Long id,
                                               @RequestParam String type,
                                               @RequestParam String addInfo) {
        return ResponseEntity.ok(typeService.updateProductTypeById(id, type, addInfo));
    }

    @ApiOperation("Удалить тип продукта")
    @DeleteMapping("deleteProductTypeById")
    public ResponseEntity<?> deleteProductTypeById(@RequestParam Long id){
        return ResponseEntity.ok(typeService.deleteProductTypeById(id));
    }
}
