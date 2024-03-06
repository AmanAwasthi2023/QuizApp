package com.aman.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aman.quiz.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>
{
	List<Question> findByCategory(String category);
	
	@Query(nativeQuery=true, value="select * from question q where q.category=:category order by rand() limit :numQ")
	List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
