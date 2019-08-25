package com.shipping.shipping.controllers;

import com.shipping.shipping.services.ClientService;
import com.shipping.shipping.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {
    private ClientService clientService;

    @Autowired(required = false)
    @Qualifier("defaultClientService")
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("getClientById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping("addClient")
    public ResponseEntity<?> addClient(@RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam String phoneNumber) {
        return ResponseEntity.ok(clientService.addClient(name, surname, phoneNumber));
    }

    @PatchMapping("updateClient")
    public ResponseEntity<?> updateClient(@RequestParam Long id,
                                          @RequestParam String name,
                                          @RequestParam String surname,
                                          @RequestParam String phoneNumber) {
        return ResponseEntity.ok(clientService.updateClientById(id, name, surname, phoneNumber));
    }

    @DeleteMapping("deleteClientById")
    public ResponseEntity<?> deleteClientById(@RequestParam Long id) {
        return ResponseEntity.ok(clientService.deleteClientById(id));
    }
}
