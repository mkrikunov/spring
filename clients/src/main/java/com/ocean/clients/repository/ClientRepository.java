package com.ocean.clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ocean.clients.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}



