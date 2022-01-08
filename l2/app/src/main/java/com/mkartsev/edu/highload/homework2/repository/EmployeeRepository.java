package com.mkartsev.edu.highload.homework2.repository;

import com.mkartsev.edu.highload.homework2.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}