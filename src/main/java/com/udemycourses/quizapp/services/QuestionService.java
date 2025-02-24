package com.udemycourses.quizapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.udemycourses.quizapp.dao.QuestionDao;
import com.udemycourses.quizapp.model.Question;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {	
	try {
		return new ResponseEntity<List<Question>>(questionDao.findAll(),HttpStatus.OK);
		}
	catch(Exception ex){
			ex.printStackTrace();
		}
	return new ResponseEntity<List<Question>>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}

	public List<Question> getQuestionsByCategory(String category) {
		return questionDao.findByCategory(category);
	}
	
	public String addQuestion(Question question ) {
		questionDao.save(question);
		return "added";
		
	}

}
