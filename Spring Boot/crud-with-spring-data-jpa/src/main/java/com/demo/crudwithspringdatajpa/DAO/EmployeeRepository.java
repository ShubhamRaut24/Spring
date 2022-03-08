package com.demo.crudwithspringdatajpa.DAO;

import com.demo.crudwithspringdatajpa.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
