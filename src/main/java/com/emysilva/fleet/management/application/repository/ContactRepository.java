package com.emysilva.fleet.management.application.repository;

import com.emysilva.fleet.management.application.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
