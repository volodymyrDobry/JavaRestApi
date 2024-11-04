package com.example.demo.Services;

import com.example.demo.Entities.Employee;
import com.example.demo.Mappers.EmployeeMapper;
import com.example.demo.Models.EmployeeDTO;
import com.example.demo.Repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::fromEmployeeToDto).toList();
    }

    public EmployeeDTO getEmployee(int id) {
        return employeeRepository.findById(id).
                map(employeeMapper::fromEmployeeToDto).
                orElseThrow(EntityNotFoundException::new);
    }

    private Employee getEmployeeById(int id) {
        return employeeRepository.
                findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.fromDtoToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.fromEmployeeToDto(savedEmployee);
    }

    public EmployeeDTO putEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        employeeMapper.fromDtoToEmployee(employeeDTO, employee);
        employeeRepository.save(employee);
        return employeeMapper.fromEmployeeToDto(employee);
    }

    public EmployeeDTO patchEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        employeeMapper.fromDtoToEmployee(employeeDTO, employee);
        employeeRepository.save(employee);
        return employeeMapper.fromEmployeeToDto(employee);
    }

    public EmployeeDTO deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
        return employeeMapper.fromEmployeeToDto(employee);
    }
}
