package org.example.domain.repository;

import org.example.domain.entity.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Job SET logs = array_cat(logs, cast(:logs as varchar[])) WHERE job_id = :job_id", nativeQuery = true)
    void appendLogs(@Param("job_id") UUID jobId, @Param("product_id") UUID productId, @Param("logs") String[] logs);

}
