package com.emysilva.fleet.management.application.repository;
import com.emysilva.fleet.management.application.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
