package com.codingdojo.dojooverflow.controllers;

import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.MainService;


@SpringBootApplication
@Controller
public class OverflowController {
private final MainService mainService;
	
	public OverflowController(MainService mainService) {
		this.mainService = mainService;
	}

	@GetMapping("/questions")
	public String AllQuestions(Model model) {
		List<Question> AllQ = mainService.allQuestions();
		model.addAttribute("Questions", AllQ);
		return "main.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String newQuestion() {
		return "QuestionForm.jsp";
	}
	
	@PostMapping("/questions/new/create")
	public String createQuestion(@RequestParam("question") String question, @RequestParam("subject") String subject) {
		String[] tags = subject.split("\\s*,\\s*");
		Question quest = mainService.createQuestion(question);
		for (String st : tags) {
			Tag returnedTag = mainService.createTag(st);
			mainService.addTag(returnedTag, quest);
		}
		return "redirect:/questions/";
	}
	
	@GetMapping("/qeustions/{qeustionId}")
	public String showQuestion(@PathVariable("questionId") Long id, Model model) {
		Question thisQuestion = mainService.findQuestion(id);
		model.addAttribute("question", thisQuestion);
		List<Answer> allAnswers = mainService.findAnswerByQuestion(id);
		model.addAttribute("answers", allAnswers);
		return "ShowQuestion.jsp";
	}
	
	@PostMapping("/qeustions/{qeustionId}/answer")
	public String showQuestion(@PathVariable("questionId") Long id, Model model, @RequestParam("answer") String answer) {
		Answer newAnswer = new Answer();
		newAnswer.setAnswer(answer);
		Question thisQuestion = mainService.findQuestion(id);
		newAnswer.setQuestion(thisQuestion);
		return "redirect:/questions/{questionId}";
	}
	
	
}
