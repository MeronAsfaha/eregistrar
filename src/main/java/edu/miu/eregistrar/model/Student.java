package edu.miu.eregistrar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotNull(message = "Student number field can't be null")
    @NotEmpty(message = "student number field can't be empty")
    private String studentNumber;
    @NotNull(message = "Student first name field can't be null")
    @NotEmpty(message = "student first name field can't be empty")
    private String firstName;
    private String middleName;
    @NotNull(message = "Student last name field can't be null")
    @NotEmpty(message = "student last name field can't be empty")
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;
    private Boolean isInternational;
}
