package com.shipping.shipping.repositories;

import com.shipping.shipping.entities.ProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Long> {
}
