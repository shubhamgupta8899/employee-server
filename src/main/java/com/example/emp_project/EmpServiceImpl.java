package com.example.emp_project;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Service: Marks this class as a Spring service component
@Service
public class EmpServiceImpl implements EmpService {

    // @Autowired: Injects the EmpRepository dependency automatically
    @Autowired
    private EmpRepository empRepository;

    // A temporary in-memory list (not used with database operations here)
    //List<Employee> employeeslist = new ArrayList<>();

    /**
     * Creates and saves a new employee record.
     * @param emp Employee object from client
     * @return Success message
     */
    @Override
    public String createEmployee(Employee emp) {
        // Create an entity object to store in the database
        EmpEntity empEntity = new EmpEntity();

        // Copies properties from Employee DTO to EmpEntity
        BeanUtils.copyProperties(emp, empEntity);

        // Saves entity to the database
        empRepository.save(empEntity);

        return "Saved Successfully";
    }


    /**
     * Reads all employee records from the database.
     * @return List of Employee objects
     */
    @Override
    public List<Employee> readEmployees() {
        // Retrieve all records from the database
        List<EmpEntity> emplist = empRepository.findAll();
        List<Employee> employeeslist = new ArrayList<>();

        // Convert each EmpEntity to Employee (DTO)
        for (EmpEntity empEntity : emplist) {
            Employee emp = new Employee();
            BeanUtils.copyProperties(empEntity, emp);
            employeeslist.add(emp);
        }

        return employeeslist;
    }

    /**
     * Deletes an employee record by ID.
     * @param id Employee ID
     * @return Boolean indicating success
     */
    @Override
    public boolean deleteEmployee(Long id) {
        // Find the employee by ID
        EmpEntity empentity = empRepository.findById(id).get();

        // Delete the record from the database
        empRepository.delete(empentity);
        return true;
    }

    /**
     * Updates an existing employee record by ID.
     * @param id Employee ID
     * @param employee Updated Employee object
     * @return Success message
     */
    public String updateEmployee(Long id, Employee employee) {
        // Find existing employee record
        EmpEntity existingEmp = empRepository.findById(id).get();



// Update fields from new employee data using BeanUtils
        BeanUtils.copyProperties(existingEmp, employee);


        // Save updated entity
        empRepository.save(existingEmp);

        return "Update Successfully";
    }

    /**
     * Reads a single employee record by ID.
     * @param id Employee ID
     * @return Employee object
     */
    @Override
    public Employee readEmployee(Long id) {
        // Find employee record by ID
        EmpEntity empEntity = empRepository.findById(id).get();

        // Convert entity to DTO
        Employee employee = new Employee();
        BeanUtils.copyProperties(empEntity, employee);

        return employee;
    }
}
