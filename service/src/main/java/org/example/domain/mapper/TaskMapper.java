package org.example.domain.mapper;

import org.example.domain.dto.TaskDTO;
import org.example.domain.entity.task.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO taskToTaskDTO(Task task);
    Task taskDTOToTask(TaskDTO taskDTO);
}
