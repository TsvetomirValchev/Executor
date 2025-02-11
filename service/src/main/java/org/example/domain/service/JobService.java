package org.example.domain.service;

import org.example.domain.entity.job.Job;
import org.example.domain.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job createJobFromTask(UUID taskId) {
        // Implementation to create a job from a task
        jobRepository.save(new Job());
        return new Job();
    }

    public Optional<Job> getJobById(UUID id) {
        // Implementation to get a job by ID

        return jobRepository.findById(id);
    }
}
