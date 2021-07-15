package com.debo.springbootpost.service;

import com.debo.springbootpost.model.Employee;
import com.debo.springbootpost.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
