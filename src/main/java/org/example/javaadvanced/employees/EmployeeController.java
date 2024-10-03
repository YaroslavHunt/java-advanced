package org.example.javaadvanced.employees;

// API Layer
// Приймає в себе дані дані з http запитів
// Може провести базову валідацію на відповідність контракту
// Передає дані бізнес лозіці (Service layer)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    public final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestParam String email,
                                   @RequestParam Integer salary) {
        return employeeService.updateEmployee(id, email, salary);
    }
}

