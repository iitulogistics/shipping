package com.shipping.shipping.controllers;

import com.shipping.shipping.services.ClientService;
import com.shipping.shipping.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
@Api(tags = "Список клиентов", description = "Api для списка клиенов")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ApiOperation("Список клиентов")
    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @ApiOperation("Возвращает клиента по его id")
    @GetMapping("getClientById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @ApiOperation("Добавить клиента")
    @PostMapping("addClient")
    public ResponseEntity<?> addClient(@RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam String phoneNumber) {
        return ResponseEntity.ok(clientService.addClient(name, surname, phoneNumber));
    }

    @ApiOperation("Обновить клиента")
    @PatchMapping("updateClient")
    public ResponseEntity<?> updateClient(@RequestParam Long id,
                                          @RequestParam String name,
                                          @RequestParam String surname,
                                          @RequestParam String phoneNumber) {
        return ResponseEntity.ok(clientService.updateClientById(id, name, surname, phoneNumber));
    }

    @ApiOperation("Удалить продукт")
    @DeleteMapping("deleteClientById")
    public ResponseEntity<?> deleteClientById(@RequestParam Long id) {
        return ResponseEntity.ok(clientService.deleteClientById(id));
    }
}
