package com.sbu.compiler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbu.compiler.domain.Lab;
@Repository
public interface LabRepository extends JpaRepository<Lab,Long> {
	
//	@Query(value="SELECT * from lab  where user_id = ?1", nativeQuery = true)
//	List<Lab> findByUserId(String user_id);
	List<Lab> findByAssignee(String user_id);
	List<Lab> findByYearAndSection(String year, String section);
	Lab findByLabId(int labId);
	
}
