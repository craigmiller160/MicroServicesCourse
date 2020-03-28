package com.krishantha.rent.demoapplication.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "stage")
public class StageEndpoint {

    private final Map<String, Stage> stages = new ConcurrentHashMap<>();

    @ReadOperation
    public Map<String, Stage> getAllStages() {
        return stages;
    }

    @ReadOperation
    public Stage getStage(@Selector String name) {
        return stages.get(name);
    }

    @WriteOperation
    public void setValue(@Selector String name, int stage) {
        stages.put(name, new Stage(stage));
    }

    @Data
    @AllArgsConstructor
    public static class Stage {
        private int value;
    }

}
