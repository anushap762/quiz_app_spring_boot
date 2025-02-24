package com.udemycourses.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemycourses.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
