package com.bixly.brightappscc.domain.employee;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(indexName = "employee_index")
@NoArgsConstructor
public class Employee {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String designation;
    private double salary;
    private LocalDateTime dateOfJoining;
    private String address;
    private String gender;
    private int age;
    private String maritalStatus;
    private List<String> interests;
}
