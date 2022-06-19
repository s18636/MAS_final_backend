package com.example.masfinalbackend.services;

import com.example.masfinalbackend.entities.Employee;
import com.example.masfinalbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repo;


    public EmployeeService(EmployeeRepository repo){
        this.repo = repo;
    }

    public long getEmployee(long id){
        Optional<Employee> employee = repo.findById(id);
        if(employee.isEmpty()){
            throw new RuntimeException();
        }
        return id;
    }
}
