package com.bixly.brightappscc.service.impl;

import com.bixly.brightappscc.domain.employee.Employee;
import com.bixly.brightappscc.domain.search.request.SearchDTO;
import com.bixly.brightappscc.domain.search.response.SearchResponse;
import com.bixly.brightappscc.repository.EmployeeRepository;
import com.bixly.brightappscc.service.EmployeeService;
import com.bixly.brightappscc.service.adapter.EmployeeAdapter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeAdapter employeeAdapter;

    @Override
    public SearchResponse getEmployeeSearch(SearchDTO searchDTO) {
        Iterable<Employee> employees = employeeRepository.findAll();

        List<Employee> employeesList = new ArrayList<>();
        for (Employee employee : employees) {
            employeesList.add(employee);
        }

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setCount(employeesList.size());
        searchResponse.setResults(employeeAdapter.getEmployeeDTOList(employeesList));
        return searchResponse;
    }
}
