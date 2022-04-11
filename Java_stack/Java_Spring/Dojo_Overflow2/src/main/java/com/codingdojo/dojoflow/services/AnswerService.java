package com.codingdojo.dojoflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoflow.models.Answer;

import com.codingdojo.dojoflow.repositories.AnswerRepository;

@Service
public class AnswerService {
		private final AnswerRepository answerRepository;

		public AnswerService(AnswerRepository answerRepository) {
			this.answerRepository = answerRepository;
		}
//finding methods
		public List<Answer> allAnswers () {
			return answerRepository.findAll();
		}
		
		public Answer findAnswerById (Long id) {
			Optional<Answer> thisAnswer=  answerRepository.findById(id);
			if (thisAnswer.isPresent()) {
				return thisAnswer.get();
			} else {
				return null;
			}
		}
//CRUD methods
		
		public Answer createAnswer (Answer answer) {
			return answerRepository.save(answer);
		}
		
}
