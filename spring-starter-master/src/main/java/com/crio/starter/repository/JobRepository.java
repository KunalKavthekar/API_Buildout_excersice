package com.crio.starter.repository;

import com.crio.starter.data.JobEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<JobEntity, String> {
    
}
