package com.sbu.compiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbu.compiler.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
	Question findByQuestionId(int QuestionId);
}
