package org.example.domain.entity.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.task.Task;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Slf4j
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Job {

    @Id
    private final UUID jobId = UUID.randomUUID();

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Include
    @JsonIgnore
    private Task task;

    @Basic(fetch = FetchType.LAZY)
    @Type(value = ListArrayType.class)
    @Column(columnDefinition = "VARCHAR ARRAY") // Used only for testing purposes
    private List<String> logs = new ArrayList<>();

}
