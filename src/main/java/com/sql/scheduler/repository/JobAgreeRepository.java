package com.sql.scheduler.repository;

import com.sql.scheduler.code.AgreeStatus;
import com.sql.scheduler.entity.JobAgree;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobAgreeRepository extends CrudRepository<JobAgree, Integer> {
	@Query(value = "SELECT ifnull(MAX(register_seq), 0) FROM job_agree WHERE job_seq = ?1", nativeQuery = true)
	int getMaxRegisterSeqByJobSeq(int jobSeq);
	long countByJobSeqAndRegisterSeqAndAgreedNot(int jobSeq, int registerJob, AgreeStatus status);
	List<JobAgree> findByJobSeqAndRegisterSeqOrderByRegDtDesc(int jobSeq, int registerJob);
	List<JobAgree> findByUsernameAndAgreedNotOrderByRegDtDesc(String username, AgreeStatus status);
}
