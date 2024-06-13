package com.EMA.EMS_Yash.Controller;

import com.EMA.EMS_Yash.EmployeeService.EmployeeServices;
import com.EMA.EMS_Yash.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Employee")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeservice;



    @GetMapping("/all-employees")
    public List<Employee> getEmployees(){
       return this.employeeservice.getEmployees();
    }

    @GetMapping("/id/{id}")
    public Optional<Employee> getEmployeebyId(@PathVariable Long id){
        return this.employeeservice.getEmployeebyId(id);
    }

    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee myEmp){
        return this.employeeservice.addEmployee(myEmp);
    }

    @DeleteMapping("/delete-employee/id/{id}")
    public void deleteEmployee(@PathVariable Long id){
        this.employeeservice.deleteEmployee(id);
    }

    @PutMapping("/update-employee/id/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee myEmp){
        return this.employeeservice.updateEmployee(id,myEmp);
    }
}
