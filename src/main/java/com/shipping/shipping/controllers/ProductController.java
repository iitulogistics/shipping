package com.shipping.shipping.controllers;

import com.shipping.shipping.entities.ProductEntity;
import com.shipping.shipping.services.impl.DefaultProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@Api(tags = {"Список продуктов"}, description = "API для списка продуктов")
public class ProductController {
    private final DefaultProductService defaultProductService;

    public ProductController(DefaultProductService defaultProductService) {
        this.defaultProductService = defaultProductService;
    }

    @ApiOperation(value = "Показывает весь список продуктов")
    @GetMapping("all")
    public List<ProductEntity> getAll() {
        return defaultProductService.getProducts();
    }

    @ApiOperation(value = "Вернуть продукт по его id")
    @GetMapping("getProduct/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(defaultProductService.getProductById(id));
    }

    @ApiOperation(value = "Добавить продукт")
    @PostMapping("addProduct")
    public ResponseEntity<?> addProduct(@RequestParam String product_name,
                                        @RequestParam Integer weight,
                                        @RequestParam Long productTypeId) {
        return ResponseEntity.ok(defaultProductService.addProduct(product_name, productTypeId, weight));
    }

    @ApiOperation(value = "Обновить продукт")
    @PatchMapping("updateProductById")
    public ResponseEntity<?> updateProductById(@RequestParam Long id,
                                               @RequestParam String product_name,
                                               @RequestParam Integer weight,
                                               @RequestParam Long productTypeId){
        return ResponseEntity.ok(defaultProductService.updateProductById(id, product_name, productTypeId, weight));
    }
}
