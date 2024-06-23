package com.myproject.demo.job.services.impl;

import com.myproject.demo.job.model.Job;
import com.myproject.demo.job.repository.JobRepository;
import com.myproject.demo.job.services.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class jobServiceimpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public jobServiceimpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job jobData) {

        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(job.getTitle());
            job.setDescription(jobData.getDescription());
            job.setMaxSalary(jobData.getMinSalary());
            job.setMinSalary(jobData.getMinSalary());
            job.setLocation(jobData.getLocation());
            jobRepository.save(job);
            return true;
        }

        return false;
    }
}
