package com.example.emp_project;

import java.util.List;

/**
 * EmpService interface defines the business logic for managing employee records.
 * This interface is implemented by a service class to handle CRUD operations.
 */
public interface EmpService {

    /**
     * Creates a new employee record.
     *
     * @param emp The employee object containing details to be saved.
     * @return A success message if the employee is created.
     */
    String createEmployee(Employee emp);

    /**
     * Retrieves a list of all employees.
     *
     * @return A list of Employee objects representing all stored employees.
     */
    List<Employee> readEmployees();

    /**
     * Deletes an employee record based on the provided ID.
     *
     * @param id The unique identifier of the employee to be deleted.
     * @return true if the deletion is successful, false otherwise.
     */
    boolean deleteEmployee(Long id);

    /**
     * Updates an existing employee record.
     *
     * @param id The unique identifier of the employee to update.
     * @param employee The updated employee object containing new details.
     * @return A success message if the update is completed.
     */
    String updateEmployee(Long id, Employee employee);

    /**
     * Retrieves a single employee record based on the provided ID.
     *
     * @param id The unique identifier of the employee to retrieve.
     * @return An Employee object representing the requested employee.
     */
    Employee readEmployee(Long id);
}
