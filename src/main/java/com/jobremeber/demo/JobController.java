package com.jobremeber.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jobremeber.demo.model.JobPost;
import com.jobremeber.demo.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    JobService service;

    @GetMapping("jobs")
    public List<JobPost> getAllJobs() {
        return service.getJobs();
    }

    @GetMapping("jobsSearch/{keyword}")
    public List<JobPost> searJobPosts(@PathVariable("keyword") String keyword) {
        return service.seaJobPosts(keyword);
    }

    @PostMapping("jobs")
    public String addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return "success";
    }
    
    @GetMapping("jobs/{postId}")
    public JobPost getMethodName(@PathVariable("postId") int postId){
        return service.getSingleJob(postId);
    }

    @PutMapping("jobs")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getSingleJob(jobPost.getPostId());
    }

    @DeleteMapping("jobs/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "Delete Done";
    }
    
    
}
