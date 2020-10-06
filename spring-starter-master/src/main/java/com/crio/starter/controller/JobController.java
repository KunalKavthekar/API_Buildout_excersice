package com.crio.starter.controller;

import com.crio.starter.dto.JobDto;
import com.crio.starter.exchange.GetJobsResponse;
import com.crio.starter.services.JobService;
import com.crio.starter.services.JobServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

  @Autowired
  JobServiceImpl jobService;

  @PutMapping("/")
  public String saveJob(@RequestBody JobDto jobDto) {

    return jobService.saveJob(jobDto);

  }
  
  @GetMapping("/")
  public ResponseEntity<GetJobsResponse> getAllJobs() {
    GetJobsResponse getAllJobsResponse;

    getAllJobsResponse = jobService.getAllJobs();

    return ResponseEntity.ok().body(getAllJobsResponse);
  }

  @GetMapping("/{location}/{searchTerm}")
  public ResponseEntity<GetJobsResponse> getJobsByLocationAndSkill(
      @PathVariable String location, @PathVariable List<String> searchTerm) {
    GetJobsResponse getJobsByLocationAndSkillResponse;

    getJobsByLocationAndSkillResponse = 
      jobService.getJobsByLocationAndSkillResponse(location, searchTerm);

    return ResponseEntity.ok().body(getJobsByLocationAndSkillResponse);
  }
}
