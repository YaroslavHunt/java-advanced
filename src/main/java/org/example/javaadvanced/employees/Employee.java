package org.example.javaadvanced.employees;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "employee")
@Getter
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_seq",
            sequenceName = "employee_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_seq"
    )
    private Long id;
    private String name;
    @Setter
    private String email;
    private LocalDate birthDate;
    @Transient                                                                       // не створює колонку в таблиці БД
    private Integer age;
    @Setter
    public Integer salary;

    public Employee() {
    }

    public Employee(Long id, String name, String email, LocalDate birthDate, Integer salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.age = Period.between(
                birthDate,
                LocalDate.now()
        ).getYears();
        this.salary = salary;
    }

    public Integer getAge() {
        if (age == null) {
            this.age = Period.between(
                    birthDate,
                    LocalDate.now()
            ).getYears();
        }
        return age;
    }
}
