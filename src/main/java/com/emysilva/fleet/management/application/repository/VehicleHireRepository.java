package com.emysilva.fleet.management.application.repository;
import com.emysilva.fleet.management.application.model.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {

}
