package com.bixly.brightappscc.web;

import com.bixly.brightappscc.domain.search.request.SearchDTO;
import com.bixly.brightappscc.domain.search.response.SearchResponse;
import com.bixly.brightappscc.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<SearchResponse> getEmployeeSearch(@Valid @RequestBody SearchDTO searchDTO) {
        return ResponseEntity.ok(employeeService.getEmployeeSearch(searchDTO));
    }


}
