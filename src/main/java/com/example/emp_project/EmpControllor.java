package com.example.emp_project;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController  // This annotation marks the class as a REST controller, which means it will handle HTTP requests and send HTTP responses. It automatically makes this class eligible for Spring's component scanning and acts as a combination of @Controller and @ResponseBody.
@CrossOrigin("https://employee-information-blue.vercel.app/")
public class EmpControllor {

    // List<Employee> list = new ArrayList<>();  // This is an in-memory list of employees (commented out as it's not being used here).
    // EmpService empService = new EmpServiceImpl();  // This is commented out because we're using Dependency Injection for the EmpService.

    @Autowired  // This annotation is used for dependency injection in Spring. It tells Spring to inject an instance of the EmpService class means object into this controller. "object are in beans".
    private EmpService empService;

    @GetMapping("/employees")  // This annotation maps HTTP GET requests to this method. It handles GET requests for retrieving all employees. The URL path for this request is "/employees".
    public List<Employee> getAllEmployees(){
        return empService.readEmployees();  // Calls the service to get all employees from the database or in-memory list.
    }

    @GetMapping("/employees/{id}")  // This annotation maps HTTP GET requests to this method. It handles GET requests for retrieving all employees. The URL path for this request is "/employees".
    public Employee getEmployeeById(@PathVariable Long id){
        return empService.readEmployee(id);  // Calls the service to get single employees from the database or in-memory list.
    }

    // @GetMapping("/employees{id}")  // This annotation maps HTTP GET requests to this method, specifically when the URL matches "/employees{id}" (e.g., "/employees/1"). It is used to fetch a specific employee by their ID.
    // public Employee getAllEmployeeById(@PathVariable Long id){  // @PathVariable binds the value from the URL path to the method parameter (id).
    //     return empService.readEmployee(id);  // Calls the service to get an employee by ID.
    // }

    @PostMapping("/employees")  // This annotation maps HTTP POST requests to this method. It is used for creating a new employee. The URL path is "/employees".
    public String postEmployee(@RequestBody Employee emp){  // @RequestBody binds the request body (which is typically JSON) to the Employee object. Spring will automatically deserialize the JSON into an Employee instance.
        return empService.createEmployee(emp);  // Calls the service to save the new employee to the database.
    }

    @DeleteMapping("/employees/{id}")  // This annotation maps HTTP DELETE requests to this method. It is used to delete an employee by their ID. The URL path is "/employees/{id}".
    public String deleteEmployee(@PathVariable Long id){  // @PathVariable binds the ID from the URL to the method parameter (id).
        if(empService.deleteEmployee(id)){
            return "Delete Successfully";  // Return success message if employee is deleted.
        } else {
            return "Not Found";  // Return failure message if the employee is not found.
        }
    }

    @PutMapping("/employees/{id}")  // This annotation maps HTTP PUT requests to this method. It is used to update an existing employee by their ID. The URL path is "/employees/{id}".
    public String putEmployee(@PathVariable Long id, @RequestBody Employee employee){  // @PathVariable binds the ID from the URL to the method parameter (id). @RequestBody binds the request body to the Employee object.
        return empService.updateEmployee(id, employee);  // Calls the service to update the employee's details.
    }
}
