package com.udemycourses.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.udemycourses.quizapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
 List<Question> findByCategory(String category);

 @Query(value="select * from Question q where q.category=:category order by random() LIMIT :numQ",nativeQuery = true)
List<Question> findRandomQuestionByCategory(String category, int numQ);
}
