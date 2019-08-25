package com.shipping.shipping.services;

import com.shipping.shipping.entities.StatusEntity;

import java.util.List;

public interface StatusService {
    StatusEntity getStatusById(Long id);

    List<StatusEntity> getStatuses();

    String addStatus(String status,
                     String addInfo);

    String updateStatusById(Long id,
                            String status,
                            String addInfo);

    String deleteStatusById(Long id);
}
