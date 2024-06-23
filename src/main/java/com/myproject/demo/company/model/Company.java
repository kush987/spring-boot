package com.myproject.demo.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myproject.demo.job.model.Job;
import com.myproject.demo.reviews.model.Reviews;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "company_table")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String about;
    private String companyLocation;
    private String companySize;
    private String companyType;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Reviews> Review;
    public Company() {}

    public Company(Long id, String companyName, String about, String companyLocation, String companySize, String companyType, List<Job> jobs) {
        this.id = id;
        this.companyName = companyName;
        this.about = about;
        this.companyLocation = companyLocation;
        this.companySize = companySize;
        this.companyType = companyType;
        this.jobs = jobs;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Reviews> getReview() {
        return Review;
    }

    public void setReview(List<Reviews> review) {
        Review = review;
    }
}
