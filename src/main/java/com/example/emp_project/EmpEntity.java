package com.example.emp_project;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data: Generates getters, setters, toString, equals, and hashCode methods automatically (Lombok)
@Data

// @Entity: Marks this class as a JPA entity (a table in the database)
@Entity

// @NoArgsConstructor: Generates a no-argument constructor (Lombok)
@NoArgsConstructor

// @AllArgsConstructor: Generates a constructor with all class fields (Lombok)
@AllArgsConstructor

// @Table: Specifies the name of the database table for this entity
@Table(name = "EmpEntity")
public class EmpEntity {

    // @Id: Marks this field as the primary key
    @Id

    // @GeneratedValue: Configures auto-generation of primary key values
    // strategy = GenerationType.IDENTITY: Relies on the database to auto-increment the ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column mapping for the 'name' field in the database
    private String name;

    // Column mapping for the 'phnNo' field (phone number)
    private String phnNo;

    // Column mapping for the 'email' field
    private String email;

}


