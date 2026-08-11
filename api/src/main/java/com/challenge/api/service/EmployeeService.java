package com.challenge.api.service;

import com.challenge.api.model.CreateEmployeeRequest;
import com.challenge.api.model.DefaultEmployee;
import com.challenge.api.model.Employee;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private Map<UUID, Employee> employeeMap = new HashMap<>();

    public EmployeeService() {
        DefaultEmployee employee1 = new DefaultEmployee(
                UUID.randomUUID(),
                "John",
                "Doe",
                "John Doe",
                80000,
                25,
                "Software Engineer I",
                "JohnDoe@company.com",
                Instant.now(),
                null);
        DefaultEmployee employee2 = new DefaultEmployee(
                UUID.randomUUID(),
                "Jane",
                "Smith",
                "Jane Smith",
                90000,
                28,
                "Software Engineer II",
                "JaneSmith@company.com",
                Instant.now(),
                null);

        employeeMap.put(employee1.getUuid(), employee1);
        employeeMap.put(employee2.getUuid(), employee2);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployeeByUuid(UUID uuid) {
        return employeeMap.get(uuid);
    }

    public Employee createEmployee(CreateEmployeeRequest request) {
        DefaultEmployee employee = new DefaultEmployee();
        employee.setUuid(UUID.randomUUID());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setFullName(request.getFullName());
        employee.setSalary(request.getSalary());
        employee.setAge(request.getAge());
        employee.setJobTitle(request.getJobTitle());
        employee.setEmail(request.getEmail());
        employee.setContractHireDate(request.getContractHireDate());

        employeeMap.put(employee.getUuid(), employee);
        return employee;
    }
}
