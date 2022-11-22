package com.ocean.clients.controller;

import org.springframework.web.bind.annotation.*;
import com.ocean.clients.entity.Client;
import com.ocean.clients.exception.ClientNotFoundException;
import com.ocean.clients.repository.ClientRepository;

import java.util.List;

@RestController
public class ClientController {

    private final ClientRepository repository;

    ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/clients")
    List<Client> all() {
        return repository.findAll();
    }

    @PostMapping("/clients")
    Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }

    @GetMapping("/clients/{id}")
    Client one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PutMapping("/clients/{id}")
    Client replaceClient(@RequestBody Client newClient, @PathVariable Long id) {

        return repository.findById(id)
                .map(client -> {
                    client.setFirstName(newClient.getFirstName());
                    client.setLastName(newClient.getLastName());
                    client.setPhoneNumber(newClient.getPhoneNumber());
                    return repository.save(client);
                })
                .orElseGet(() -> {
                    newClient.setId(id);
                    return repository.save(newClient);
                });
    }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}