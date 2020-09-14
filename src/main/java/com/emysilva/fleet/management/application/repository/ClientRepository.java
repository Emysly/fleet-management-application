package com.emysilva.fleet.management.application.repository;

import com.emysilva.fleet.management.application.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
