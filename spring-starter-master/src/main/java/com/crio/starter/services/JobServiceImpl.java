package com.crio.starter.services;

import com.crio.starter.data.JobEntity;
import com.crio.starter.dto.JobDto;
import com.crio.starter.exchange.GetJobsResponse;
import com.crio.starter.repository.JobRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// import javax.inject.Provider;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

  @Autowired
  JobRepository jobRepository;

  @Autowired
  private MongoTemplate mongoTemplate;

  // @Autowired
  // private Provider<ModelMapper> modelMapperProvider;

  @Override
  public String saveJob(JobDto jobDto) {

    ModelMapper modelMapper = new ModelMapper();

    JobEntity job = modelMapper.map(jobDto, JobEntity.class);

    mongoTemplate.save(job, "jobs");

    return "Success";
  }

  @Override
  public GetJobsResponse getAllJobs() {
    List<JobEntity> allJobs = mongoTemplate.findAll(JobEntity.class); 

    List<JobDto> listOfJobs = new ArrayList<JobDto>();

    ModelMapper modelMapper = new ModelMapper();

    for (JobEntity job : allJobs) {
      JobDto jobDto = modelMapper.map(job, JobDto.class);
      listOfJobs.add(jobDto);
    }

    GetJobsResponse getAllJobsResponse = new GetJobsResponse(listOfJobs);

    return getAllJobsResponse;
  }

  @Override
  public GetJobsResponse getJobsByLocationAndSkillResponse(
      String location, List<String> searchTerm) {

    List<JobEntity> allJobs = mongoTemplate.findAll(JobEntity.class); 

    List<JobDto> listOfJobs = new ArrayList<JobDto>();
    List<JobDto> goodJobs = new ArrayList<JobDto>();

    ModelMapper modelMapper = new ModelMapper();

    Set<String> skillSet = new HashSet<String>();
    for (String x : searchTerm) {
      skillSet.add(x);
    }

    if (skillSet.size() <= 0 || skillSet.size() > 3) {
      return null;
    }

    for (JobEntity job : allJobs) {

      JobDto jobDto = modelMapper.map(job, JobDto.class);
      listOfJobs.add(jobDto);
    }

    
    for (JobDto thisJob : listOfJobs) {

      if (thisJob.getJobLocation().equals(location)) {  //  (thisJob.getJobLocation() == location)
        for (String skill : thisJob.getSkillKeywords()) {
          if (skillSet.contains(skill)) {
            goodJobs.add(thisJob);
          }
        }
      }
    }

    GetJobsResponse getAllJobsResponse = new GetJobsResponse(goodJobs);

    return getAllJobsResponse;
  } 
}