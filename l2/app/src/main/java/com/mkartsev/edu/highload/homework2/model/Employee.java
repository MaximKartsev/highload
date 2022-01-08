package com.mkartsev.edu.highload.homework2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "Employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;

    @NotBlank
    @Size(max = 100)
    private String firstName;
    private String lastName;

    @NotBlank
    @Size(max = 100)
    private String emailId;

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
}