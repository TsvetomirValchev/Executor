// JobService.java
package org.example.domain.service;

import org.example.domain.dto.JobDTO;
import org.example.domain.entity.job.Job;
import org.example.domain.entity.task.Task;
import org.example.domain.mapper.JobMapper;
import org.example.domain.repository.JobRepository;
import org.example.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private TaskRepository taskRepository;

    private final JobMapper jobMapper = JobMapper.INSTANCE;

    public JobDTO createJobFromTask(UUID taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        Job job = new Job();
        job.setTask(task);
        job = jobRepository.save(job);
        return jobMapper.jobToJobDTO(job);
    }

    public Optional<JobDTO> getJobById(UUID id) {
        return jobRepository.findById(id)
                .map(jobMapper::jobToJobDTO);
    }

}
