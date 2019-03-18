package com.sbu.compiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbu.compiler.domain.Solution;


@Repository
public interface SolutionRepository extends JpaRepository<Solution,Long>{
	@Query(value="SELECT * from solution  where user_id = ?1 and lab_id=?2 and question_id=?3", nativeQuery = true)
	Solution findWithUserIdAndLabIdAndQuestionId(String user_id,int lab_id,int question_id);


}
