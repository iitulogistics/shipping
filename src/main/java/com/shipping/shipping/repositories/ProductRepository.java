package com.shipping.shipping.repositories;

import com.shipping.shipping.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<ProductEntity, Long> {
}
