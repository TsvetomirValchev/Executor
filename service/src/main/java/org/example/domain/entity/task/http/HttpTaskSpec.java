package org.example.domain.entity.task.http;

import org.example.domain.entity.task.TaskSpec;

public class HttpTaskSpec extends TaskSpec {

    private String url;
    private String method;
    private String body;

    @Override
    public String getType() {
        return null;
    }

}
