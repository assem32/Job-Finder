package com.jobremeber.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobremeber.demo.model.JobPost;
import com.jobremeber.demo.repo.Repo;


@Service
public class JobService {

    @Autowired
    Repo repo; 

    public List<JobPost> getJobs(){
        return repo.findAll();
    }

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
        System.out.println(getJobs());
    }

    public JobPost getSingleJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> seaJobPosts (String keyword){
        return repo.findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(keyword, keyword);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }
    
}
