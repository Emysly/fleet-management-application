package com.emysilva.fleet.management.application.repository;
import com.emysilva.fleet.management.application.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
