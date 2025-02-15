package org.example.domain.dto;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Builder;
import lombok.Data;
import org.example.domain.entity.task.TaskType;

import java.util.UUID;

@Data
@Builder
public class TaskDTO {

    private UUID id;
    private String name;
    private TaskType type;
    private ObjectNode taskSpec;

}
