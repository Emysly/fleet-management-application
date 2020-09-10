package com.emysilva.fleet.management.application.repository;

import com.emysilva.fleet.management.application.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
