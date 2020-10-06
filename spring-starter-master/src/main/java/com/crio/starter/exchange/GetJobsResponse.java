package com.crio.starter.exchange;

import com.crio.starter.dto.JobDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @AllArgsConstructor
public class GetJobsResponse {


  private List<JobDto> listOfJobs;
  
  
  public GetJobsResponse(List<JobDto> listOfJobs) {
    this.listOfJobs = listOfJobs;
  }
  
}
