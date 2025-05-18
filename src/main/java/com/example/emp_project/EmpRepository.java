package com.example.emp_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository: Marks this interface as a Spring Data Repository,
// allowing it to perform CRUD operations on the database
@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Long> {

    // JpaRepository provides built-in CRUD methods:
    // - save()       -> Create or Update a record
    // - findById()   -> Read a record by its ID
    // - findAll()    -> Read all records
    // - deleteById() -> Delete a record by its ID
    // - count()      -> Count total records

    // JpaRepository<EmpEntity, Long>:
    // - EmpEntity: The entity class to manage (table)
    // - Long: The type of the entity's primary key

    // You can add custom query methods here if needed.


}
