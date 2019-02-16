package com.sbu.compiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbu.compiler.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	Student findByUserId(String user_id);
}
