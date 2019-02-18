package com.sbu.compiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbu.compiler.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
//	public final static String FIND_WITH_USER_ID = "SELECT section, year from student where user_id = ?1";


	@Query(value="SELECT * from student  where user_id = ?1", nativeQuery = true)
	Student findWithUserId(String user_id);
}
