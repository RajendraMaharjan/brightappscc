package com.bixly.brightappscc.service;

import com.bixly.brightappscc.domain.search.request.SearchDTO;
import com.bixly.brightappscc.domain.search.response.SearchResponse;

import java.util.List;

public interface EmployeeService {
    SearchResponse getEmployeeSearch(SearchDTO searchDTO);
}
