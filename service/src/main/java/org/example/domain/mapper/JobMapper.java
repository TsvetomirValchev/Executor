package org.example.domain.mapper;

import org.example.domain.dto.JobDTO;
import org.example.domain.entity.job.Job;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JobMapper {
    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    JobDTO jobToJobDTO(Job job);
    Job jobDTOToJob(JobDTO jobDTO);
}
