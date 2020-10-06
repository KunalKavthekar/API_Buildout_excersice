package com.crio.starter.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobEntity {
  
  @Id
  private String id;
  private String companyName;
  private String jobTitle;
  private String jobLocation;
  private String jobDescription;
  private List<String> skillKeywords;

}
