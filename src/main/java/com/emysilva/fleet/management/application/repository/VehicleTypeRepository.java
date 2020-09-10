package com.emysilva.fleet.management.application.repository;
import com.emysilva.fleet.management.application.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {

}
