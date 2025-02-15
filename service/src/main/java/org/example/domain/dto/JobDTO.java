package org.example.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.example.domain.entity.task.Task;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class JobDTO {

    private UUID jobId;
    private Task task;
    private List<String> logs;

}
