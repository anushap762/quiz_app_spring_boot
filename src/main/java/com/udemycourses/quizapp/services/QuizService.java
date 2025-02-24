package com.udemycourses.quizapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.udemycourses.quizapp.dao.QuestionDao;
import com.udemycourses.quizapp.dao.QuizDao;
import com.udemycourses.quizapp.model.Question;
import com.udemycourses.quizapp.model.QuestionWrapper;
import com.udemycourses.quizapp.model.Quiz;
import com.udemycourses.quizapp.model.Response;

@Service
public class QuizService {
	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	public ResponseEntity<String> addQuestion(String category, int numQ, String title) {
		try {
			List<Question> questions=questionDao.findRandomQuestionByCategory(category,numQ);
			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setQuestions(questions);
			quizDao.save(quiz);
			return new ResponseEntity<String>("added",HttpStatus.CREATED);
			}
		catch(Exception ex){
				ex.printStackTrace();
			}
		return new ResponseEntity<String>("something went wrong",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz=quizDao.findById(id);
		List<Question> questionsFromDb=quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for (Question question : questionsFromDb) {
			QuestionWrapper qw=new QuestionWrapper(question.getId(),question.getQuestionTitle(), question.getOption1(), question.getOption2(),question.getOption3(), question.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<List<QuestionWrapper>>(questionsForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
		List<Question> questions = quizDao.findById(id).get().getQuestions();
		int right=0;
		int i=0;
		for (Response response : responses) {
			if(response.getSelectedResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			i++;
		}
		return new ResponseEntity<Integer>(right,HttpStatus.OK);
	}
	

}
