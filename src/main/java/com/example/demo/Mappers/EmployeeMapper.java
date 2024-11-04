package com.example.demo.Mappers;

import com.example.demo.Entities.Dish;
import com.example.demo.Entities.Employee;
import com.example.demo.Models.DishDTO;
import com.example.demo.Models.EmployeeDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee fromDtoToEmployee(EmployeeDTO employeeDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EmployeeDTO fromEmployeeToDto(Employee employee);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromDtoToEmployee(EmployeeDTO employeeDTO,@MappingTarget Employee employee);

    // Custom method to retain old value if new value is zero
    default Integer retainOldValueIfZero(Integer newValue, Integer oldValue) {
        return (newValue != null) ? newValue : oldValue;
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Employee employee, EmployeeDTO dto) {
        employee.setSalary(retainOldValueIfZero(dto.getSalary(), employee.getSalary()));
    }


}
