package org.example.domain.service;

import org.example.domain.entity.task.Task;
import org.example.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {

        return new Task();
    }

    public Task getTaskById(UUID id) {
        // Implementation to get a task by ID\
        return new Task();
    }

    public List<Task> getAllTasks() {
        // Implementation to get all tasks
        return List.of(new Task());
    }

    public void deleteTask(UUID id) {
        // Implementation to delete a task by ID
    }

    public Task updateTask(UUID id, Task task) {
        // Implementation to update a task by ID
        return new Task();
    }
}
