package org.example.javaadvanced.employees;

// ініціалізує дефолтні значення в базу даних (не обовязковий)

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return (args) -> {
            var employeeDefaultList = List.of(
                    new Employee(
                            null,
                            "John",
                            "john@mail.com",
                            LocalDate.of(1992, 8, 5),
                            34000
                    ),
                    new Employee(
                            null,
                            "Mary",
                            "mary@mail.com",
                            LocalDate.of(2000, 1, 13),
                            42600
                    )
            );
            employeeRepository.saveAll(employeeDefaultList);
        };
    }

}
