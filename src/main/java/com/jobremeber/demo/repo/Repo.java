package com.jobremeber.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jobremeber.demo.model.JobPost;
import java.util.List;

@Repository
public interface Repo extends JpaRepository<JobPost,Integer>{

    List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String keyword,String searchWord);
        
}
