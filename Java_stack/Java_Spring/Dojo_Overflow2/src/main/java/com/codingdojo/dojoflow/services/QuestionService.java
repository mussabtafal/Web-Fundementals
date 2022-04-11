package com.codingdojo.dojoflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoflow.models.Question;
import com.codingdojo.dojoflow.repositories.QuestionRepository;


@Service
public class QuestionService {
	private final QuestionRepository questionRepository;

	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
//finding methods
	public List<Question> allQuestions () {
		return questionRepository.findAll();
	}
	
	public Question findQuestionById (Long id) {
		Optional<Question> thisQuestion=  questionRepository.findById(id);
		if (thisQuestion.isPresent()) {
			return thisQuestion.get();
		} else {
			return null;
		}
	}
	
//CRUD methods
	
	public Question createQuestion (Question question) {
		return questionRepository.save(question);
	}
	
	public Question updateQuestion(Question question) {
		Question thisQuestion = questionRepository.findById(question.getId()).orElse(null);
		assert thisQuestion != null;
		thisQuestion.setName(question.getName());
		return questionRepository.save(question);
	}
	

	
	

}
