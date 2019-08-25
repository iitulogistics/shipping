package com.shipping.shipping.services.impl;

import com.shipping.shipping.entities.StatusEntity;
import com.shipping.shipping.repositories.StatusRepository;
import com.shipping.shipping.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class DefaultStatusService implements StatusService {
    private StatusRepository repository;

    @Autowired(required = false)
    public void setStatusRepository(StatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public StatusEntity getStatusById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<StatusEntity> getStatuses() {
        return repository.findAll();
    }

    @Override
    public String addStatus(String status, String addInfo) {
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setAddInfo(addInfo);
        statusEntity.setStatus(status);

        repository.save(statusEntity);
        return "Status is added";
    }

    @Override
    public String updateStatusById(Long id, String status, String addInfo) {
        StatusEntity entity = repository.getOne(id);
        entity.setStatus(status);
        entity.setAddInfo(addInfo);

        repository.save(entity);
        return "Status is updated";
    }

    @Override
    public String deleteStatusById(Long id) {
        repository.deleteById(id);
        return "Status id deleted";
    }
}
