package com.example.springbbootfirst.Services;

import com.example.springbbootfirst.Models.*;
import com.example.springbbootfirst.Repository.RegisterDetailsRepository;
import com.example.springbbootfirst.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    @Autowired
    private RegisterDetailsRepository details;

    @Autowired
    private RolesRepository rolesRepository;

    public List<RegisterDetails> getAllEmployees() {
        return details.findAll();
    }


    public RegisterDetails getEmployeeById(int empId){
       Optional<RegisterDetails> employee = details.findById(empId);
       return employee.orElse(null);
    }

    public List<EmployeeRoleDTO> getEmployeeByRole(String roleName){
        return details.findEmployeeNamesByRoleName(roleName);
    }


    public String deleteEmployeeById(int empId) {
          if(details.existsById(empId)){
              details.deleteById(empId);
              return "EMPLOYEE DELETED SUCCESSFULLY";
          }
          else{
              return "Employee not found";
          }
    }

    public String deleteAllEmployee(){
    if(!details.findAll().isEmpty()){
        details.deleteAll();
        return "Employee data deleted Successfully";
    }
    else{
        return "Employee data is empty";
    }
    }

    public String updateRecord(int empId, UserDetailsDto dto){
        Optional<RegisterDetails> employee = details.findById(empId);
        if(employee.isEmpty()){
            return "Employee Not Found";
        }
        RegisterDetails updated = employee.get();

        updated.setName(dto.getName());
        updated.setEmail(dto.getEmail());
        updated.setPassword(dto.getPassword());
        updated.setUserName(dto.getUserName());

        details.save(updated);
        return "Employee Updated Successfuly";
    }

}
