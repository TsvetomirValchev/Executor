package org.example.domain.entity.task.cf;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.domain.entity.task.TaskSpec;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonTypeName(CfTaskSpec.JSON_TYPE_NAME)
public class CfTaskSpec extends TaskSpec {

    public static final String JSON_TYPE_NAME = "CF_TASK";

    private CfTaskTarget target;

    @Override
    public String getType() {
        return JSON_TYPE_NAME;
    }

}
