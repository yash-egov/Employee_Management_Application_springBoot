package com.EMA.EMS_Yash.EmployeeService;

import com.EMA.EMS_Yash.Entities.Employee;
import com.EMA.EMS_Yash.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServices {


    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeebyId(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee addEmployee(Employee myEmp) {
        return employeeRepository.save(myEmp);
    }

    @Override
    public void deleteEmployee(Long id) {
         employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee myEmp) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(myEmp.getFirstName());
            employee.setLastName(myEmp.getLastName());
            employee.setDepartment(myEmp.getDepartment());
            employee.setSalary(myEmp.getSalary());
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }


}
