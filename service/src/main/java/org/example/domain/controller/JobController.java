package org.example.domain.controller;

import org.example.domain.dto.JobDTO;
import org.example.domain.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("/activate/{taskId}")
    public ResponseEntity<JobDTO> activateJob(@PathVariable UUID taskId) {
        JobDTO job = jobService.createJobFromTask(taskId);
        return ResponseEntity.ok(job);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable UUID id) {
        JobDTO job = jobService.getJobById(id)
                .orElse(null);
        return ResponseEntity.ok(job);
    }

}
