package com.bixly.brightappscc.service.impl;

import com.bixly.brightappscc.domain.employee.Employee;
import com.bixly.brightappscc.domain.search.request.SearchDTO;
import com.bixly.brightappscc.domain.search.response.SearchResponse;
import com.bixly.brightappscc.repository.EmployeeRepository;
import com.bixly.brightappscc.service.EmployeeService;
import com.bixly.brightappscc.service.adapter.EmployeeAdapter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RestHighLevelClient elasticsearchClient;
    private final EmployeeAdapter employeeAdapter;

    @Override
    public SearchResponse getEmployeeSearch(SearchDTO searchDTO) {

//        loadData();
//
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


//        Iterable<Employee> employees = employeeRepository.findAll();
        Iterable<Employee> employees = null;

        List<Employee> employeesList = new ArrayList<>();
        for (Employee employee : employees) {
            employeesList.add(employee);
        }

        SearchResponse searchResponse = SearchResponse.builder().count(employeesList.size())
                .results(employeeAdapter.getEmployeeDTOList(employeesList)).build();

        return searchResponse;
    }

    private void loadData() {
        InputStream inputStream = getClass()
                .getResourceAsStream("./");




        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            BulkRequest bulkRequest = new BulkRequest();

            while ((line = reader.readLine()) != null) {
                bulkRequest.add(new IndexRequest("employees").source(line));
            }

            elasticsearchClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
