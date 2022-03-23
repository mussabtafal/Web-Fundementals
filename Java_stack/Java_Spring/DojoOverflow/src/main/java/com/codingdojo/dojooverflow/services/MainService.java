package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;
import com.codingdojo.dojooverflow.repositories.TagRepository;




@Service
public class MainService {
	private final QuestionRepository questionRepository;
	private final TagRepository tagRepository;
	private final AnswerRepository answerRepository;
	
	 public MainService(QuestionRepository questionRepository, TagRepository tagRepository, AnswerRepository answerRepository) {
	        this.questionRepository = questionRepository;
	        this.tagRepository = tagRepository;
	        this.answerRepository = answerRepository;
	    }
		 
//		 Question Specific Services		 
	 public List<Question> allQuestions() {
	        return questionRepository.findAll();
	    }
	 
	 public Question createQuestion(String question) {
		 Question newQuestion = new Question(question);
	        return questionRepository.save(newQuestion);
	    }
	 
	 public Question findQuestion(Long id) {
	        Optional<Question> optionalQuestion = questionRepository.findById(id);
	        if(optionalQuestion.isPresent()) {
	            return optionalQuestion.get();
	        } else {
	            return null;
	        }
	    }
	 
//	 public Iterable<Tag> availableTagsForQuestion(Question question) {
//			return tagRepository.findByQuestionsNotContains(question);
//		}
	 
	 public Question addTag(Tag e, Question c) {
		 c.getTags().add(e);
	       return questionRepository.save(c);
	    }
	 
//	   Tag Specific Services		 
	 public List<Tag> allTags() {
	        return tagRepository.findAll();
	    }
	 
	 public Tag createTag(String tag) {
		 Tag newTag = new Tag(tag);
	        return tagRepository.save(newTag);
	    }
	 
	 public Tag findTag(Long id) {
	        Optional<Tag> optionalTag = tagRepository.findById(id);
	        if(optionalTag.isPresent()) {
	            return optionalTag.get();
	        } else {
	            return null;
	        }
	    }
	 
//	 public Iterable<Question> availableQuestionsForTag(Tag tag) {
//			return questionRepository.findByTagsNotContains(tag);
//		}
	 
	 public Tag addQuestion(Tag e, Question c) {
		 e.getQuestions().add(c);
	       return tagRepository.save(e);
	    }
	 
//      Answer Specific Services
	 
	 public List<Answer> allAnswers() {
	        return answerRepository.findAll();
	    }
	 
	 public List<Answer> findAnswerByQuestion(Long id){
		 return answerRepository.findByQuestion_id(id);
	 }
	 
	 public Answer createAnswer(Answer e) {
	        return answerRepository.save(e);
	    }
	 
	 
	 
 
 
}
