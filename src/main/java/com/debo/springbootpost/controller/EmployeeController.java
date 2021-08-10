package com.debo.springbootpost.controller;

import com.debo.springbootpost.dto.EmployeeNameDto;
import com.debo.springbootpost.model.Employee;
import com.debo.springbootpost.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

    @GetMapping("/all")
    public Flux<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Employee>> getEmployeeById(@PathVariable("id") Long id) {
        return this.employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteEmployeeById(@PathVariable("id") Long id) {
          return this.employeeService.deleteEmployeeById(id);
    }

    @PatchMapping("/{id}")
    public Mono<ResponseEntity<Employee>> updateEmployeeByIdWithPath(@PathVariable("id") Long id,
                                                     @RequestBody EmployeeNameDto employee) {
        return this.employeeService.updateEmployeeByIdWithPatch(id, employee)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
