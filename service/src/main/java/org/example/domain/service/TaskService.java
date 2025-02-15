// TaskService.java
package org.example.domain.service;

import org.example.domain.dto.TaskDTO;
import org.example.domain.entity.task.Task;
import org.example.domain.mapper.TaskMapper;
import org.example.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskMapper.taskDTOToTask(taskDTO);
        task = taskRepository.save(task);
        return taskMapper.taskToTaskDTO(task);
    }

    public TaskDTO getTaskById(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        return taskMapper.taskToTaskDTO(task);
    }

    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::taskToTaskDTO)
                .collect(Collectors.toList());
    }

    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }

    public TaskDTO updateTask(UUID id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        taskMapper.taskDTOToTask(taskDTO);
        task = taskRepository.save(task);
        return taskMapper.taskToTaskDTO(task);
    }

}
