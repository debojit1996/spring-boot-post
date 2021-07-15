package com.debo.springbootpost.controller;

import com.debo.springbootpost.model.Employee;
import com.debo.springbootpost.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }
}
