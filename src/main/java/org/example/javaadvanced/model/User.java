package org.example.javaadvanced.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.javaadvanced.model.view.Viewer;

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
    @JsonView(Viewer.Private.class)
    private Long id;
    @JsonView({Viewer.Public.class, Viewer.Private.class})
    private String firstName;
    @JsonView({Viewer.Public.class, Viewer.Private.class})
    private String lastName;
    @JsonView({Viewer.Public.class, Viewer.Private.class})
    private LocalDate birthDate;
    @Column(unique = true)
    @JsonView(Viewer.Private.class)
    private String email;
    @Transient
    private Integer age;

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}

