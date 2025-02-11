package org.example.domain.dto;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.domain.entity.task.TaskType;
import org.hibernate.annotations.Type;

@Data
@Builder
public class TaskInput {

    public  String name;

    private TaskType type;

    @Type(value = JsonBinaryType.class)
    @Column(columnDefinition = "CHARACTER VARYING") // Used only for testing purposes
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @EqualsAndHashCode.Exclude
    private ObjectNode taskSpec;

}
