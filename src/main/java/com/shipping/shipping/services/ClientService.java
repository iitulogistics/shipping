package com.shipping.shipping.services;

import com.shipping.shipping.entities.ClientEntity;

import java.util.List;

public interface ClientService {
    ClientEntity getClientById(Long id);

    List<ClientEntity> getClients();

    String addClient(String name,
                     String surname,
                     String phoneNumber);

    String updateClientById(Long id,
                            String name,
                            String surname,
                            String phoneNumber);

    String deleteClientById(Long id);
}
