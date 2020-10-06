package com.crio.starter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobDto {
  @Id
  @JsonIgnore
  private String id;
  private String companyName;
  private String jobTitle;
  private String jobLocation;
  private String jobDescription;
  private List<String> skillKeywords;

  public String getCompanyName() {
    return companyName;
  }

  public List<String> getSkillKeywords() {
    return skillKeywords;
  }

  public void setSkillKeywords(List<String> skillKeywords) {
    this.skillKeywords = skillKeywords;
  }

  public String getJobDescription() {
    return jobDescription;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  public String getJobLocation() {
    return jobLocation;
  }

  public void setJobLocation(String jobLocation) {
    this.jobLocation = jobLocation;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }


  // Json structure of "Job" posting for reference
  // {
  //   "companyName": "Crio.do",
  //   "jobTitle": "Software Engineer",
  //   "jobLocation": "Pune, Maharashtra",
  //   "jobDescription": "The ideal candidate will be responsible for 
  //                        developing high-quality applications. \n 
  //                        They will also be responsible for designing 
  //                        and implementing testable and scalable code.",
  //   "skillKeywords": [
  //    "Computer Science",
  //    "SQL",
  //    "Databases",
  //    "Programming",
  //    "Web Applications",
  //    "Design",
  //   ]
  //  },
}
