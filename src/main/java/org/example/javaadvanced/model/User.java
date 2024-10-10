package org.example.javaadvanced.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Column(unique = true)
    private String email;
    @Transient
    private Integer age;

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}

