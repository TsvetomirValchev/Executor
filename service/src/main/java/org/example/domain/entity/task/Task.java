package org.example.domain.entity.task;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Task {

    @Id
    private UUID id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private TaskType type;

    @Type(value = JsonBinaryType.class)
    @Column(columnDefinition = "CHARACTER VARYING") // Used only for testing purposes
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @EqualsAndHashCode.Exclude
    private ObjectNode taskSpec;

}
