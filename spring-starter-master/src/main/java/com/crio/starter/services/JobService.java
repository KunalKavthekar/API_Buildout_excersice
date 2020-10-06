package com.crio.starter.services;

import com.crio.starter.dto.JobDto;
import com.crio.starter.exchange.GetJobsResponse;

import java.util.List;

public interface JobService {

  String saveJob(JobDto jobDto);

  GetJobsResponse getAllJobs();

  GetJobsResponse getJobsByLocationAndSkillResponse(String location, List<String> searchTerm);
  
}
