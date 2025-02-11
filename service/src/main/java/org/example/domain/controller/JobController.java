package org.example.domain.controller;


import org.example.domain.entity.job.Job;
import org.example.domain.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/activate/{taskId}")
    public ResponseEntity<Job> activateJob(@PathVariable UUID taskId) {
        Job job = jobService.createJobFromTask(taskId);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable UUID id) {
        Optional<Job> job = jobService.getJobById(id);
        return ResponseEntity.ok(job.orElseGet(Job::new));
    }
}
