package com.shipping.shipping.repositories;

import com.shipping.shipping.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
}
