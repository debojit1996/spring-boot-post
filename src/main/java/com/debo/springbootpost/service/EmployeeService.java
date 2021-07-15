package com.debo.springbootpost.service;

import com.debo.springbootpost.model.Employee;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    public Mono<Employee> createEmployee(Employee employee);
}
