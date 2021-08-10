package com.debo.springbootpost.service;

import com.debo.springbootpost.dto.EmployeeNameDto;
import com.debo.springbootpost.model.Employee;
import com.debo.springbootpost.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    @Override
    public Mono<Employee> createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Mono<Void> deleteEmployeeById(Long id) {
        return employeeRepository.existsById(id)
                .flatMap(exists -> this.employeeRepository.deleteById(id));
    }

    @Override
    public Mono<Employee> updateEmployeeByIdWithPatch(Long id, EmployeeNameDto employeeNameDto) {
        var employee = new Employee();
        return employeeRepository.findById(id)
                .map(e -> {
                    employee.setId(e.getId());
                    employee.setName(employeeNameDto.getName());
                    employee.setEmail(e.getEmail());
                    return employee; })
                .flatMap(emp -> this.employeeRepository.save(employee));
    }


}
