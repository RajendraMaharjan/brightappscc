package com.bixly.brightappscc.service.adapter;

import com.bixly.brightappscc.domain.employee.Employee;
import com.bixly.brightappscc.domain.employee.response.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeAdapter {
    @Autowired
    ModelMapper modelMapper;

    public EmployeeDTO getEmployeeDTOFromEmployee(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getEmployeeDTOList(List<Employee> employees) {
        return employees.stream()
                .map(emp -> modelMapper.map(emp, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

}
