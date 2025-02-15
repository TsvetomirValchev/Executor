package org.example.domain.entity.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.domain.entity.task.cf.CfTaskSpec;
import org.example.domain.entity.task.http.HttpTaskSpec;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = CfTaskSpec.class), @JsonSubTypes.Type(value = HttpTaskSpec.class)})
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class TaskSpec {

    @JsonIgnore
    public abstract String getType();

}
