package org.example.javaadvanced.employees;

// Service Layer
// Виконує логіку по роботі з Employee

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        if (employee.getId() != null) {
            throw new IllegalArgumentException("Id must be empty");
        }
        // унікальність пошти
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exist");
        }
        // зарплата > 7 000
        if (employee.getSalary() <= 7000) {
            throw new IllegalArgumentException("Salary must be greater than 7000");
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Employee by id=%s does not exist".formatted(id));
        }
        employeeRepository.deleteById(id);
    }

    // Зміна пошти і зарплатні працівника за допомогою реквест параметрів
    //(localhost:8080/update/{id}?email={newEmail}&salary={newSalary})
    public Employee updateEmployee(Long id, String email, Integer salary) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id=%s does not exist".formatted(id)));

        employee.setEmail(email);
        employee.setSalary(salary);

        return employeeRepository.save(employee);
    }
}
