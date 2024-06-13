package com.EMA.EMS_Yash.EmployeeService;

import com.EMA.EMS_Yash.Entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServices {

    public List<Employee> getEmployees();

    public Optional<Employee> getEmployeebyId(Long id);

    public Employee addEmployee(Employee myEmp);


   public void deleteEmployee(Long id);
   public Employee updateEmployee(Long id,Employee myEmp);
}
