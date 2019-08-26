package com.shipping.shipping.services.impl;

import com.shipping.shipping.entities.ClientEntity;
import com.shipping.shipping.repositories.ClientRepository;
import com.shipping.shipping.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultClientService implements ClientService {
    private final ClientRepository repository;

    public DefaultClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClientEntity getClientById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ClientEntity> getClients() {
        return repository.findAll();
    }

    @Override
    public String addClient(String name, String surname, String phoneNumber) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(name);
        clientEntity.setSurname(surname);
        clientEntity.setPhoneNumber(phoneNumber);
        repository.save(clientEntity);
        return "Client is added";
    }

    @Override
    public String updateClientById(Long id,
                                   String name,
                                   String surname,
                                   String phoneNumber) {
        ClientEntity entity = repository.getOne(id);
        entity.setPhoneNumber(phoneNumber);
        entity.setSurname(surname);
        entity.setName(name);

        repository.save(entity);
        return "Client is updated";
    }

    @Override
    public String deleteClientById(Long id) {
        repository.deleteById(id);
        return "Client is deleted";
    }
}
