package com.bixly.brightappscc.domain.search.response;

import com.bixly.brightappscc.domain.employee.response.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResponse {
    private int count;
    List<EmployeeDTO> results;

}
