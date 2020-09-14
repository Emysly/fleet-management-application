package com.emysilva.fleet.management.application.repository;
import com.emysilva.fleet.management.application.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
