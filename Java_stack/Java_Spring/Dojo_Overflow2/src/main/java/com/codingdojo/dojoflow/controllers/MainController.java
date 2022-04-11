package com.codingdojo.dojoflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojoflow.models.Answer;
import com.codingdojo.dojoflow.models.Question;
import com.codingdojo.dojoflow.models.Tag;
import com.codingdojo.dojoflow.services.AnswerService;
import com.codingdojo.dojoflow.services.QuestionService;
import com.codingdojo.dojoflow.services.TagService;

@Controller
public class MainController {
	private final QuestionService questionService;
	private final AnswerService answerService;
	private final TagService tagService;
	
	public MainController(QuestionService questionService, AnswerService answerService, TagService tagService) {
		this.questionService = questionService;
		this.answerService = answerService;
		this.tagService = tagService;
	}
	
	
	@GetMapping("/questions")
	public String dashboard(Model model) {
		List<Question> allQuestions = questionService.allQuestions();
		model.addAttribute("allQuestions", allQuestions);
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion() {
		return "QuestionForm.jsp";
	}
	
	@PostMapping("/questions/new")
	public String createQuestion(@RequestParam("question") String question,
			@RequestParam("tags") String tags, RedirectAttributes redirectAttributes) {
			boolean errorExists = false;
			redirectAttributes.addFlashAttribute("tags",tags);
			redirectAttributes.addFlashAttribute("question",question);
			if (question.length() < 1) {
				redirectAttributes.addFlashAttribute("errorTagQ", "*Question field must not be empty");
				errorExists = true;
			}
			if(tags.length() < 1) {
				redirectAttributes.addFlashAttribute("errorTag", "*Tags field must not be empty");
				errorExists = true;
			}
			if(!tags.contains(",")) {
				redirectAttributes.addFlashAttribute("errorTag", "*Tags must be seperated by commas");
				errorExists = true;
			}
			//split tags into array by ',' delimiter, removing any whitespace, lowercase all
			tags = tags.replaceAll("\\s", "");
			tags = tags.toLowerCase();
			String[] tagArr = tags.split(",");
			
			if(tagArr.length > 3) {
				redirectAttributes.addFlashAttribute("errorTag", "*Maximum of 3 tags per question");
				errorExists = true;
			}
			
			if(errorExists) {
				return "redirect:/questions/new";
			} else {
				Question newQuestion = new Question(question);
				questionService.createQuestion(newQuestion);
				for(String tag : tagArr) {
					if(!tagService.ifTagExistsBySubject(tag)) {
						System.out.println("This is a new Tag");
						Tag newTag = new Tag(tag);
						Tag addedTag = tagService.createTag(newTag);
						List<Question> tQues = new ArrayList<Question>();
						addedTag.setTagQuestions(tQues);
						tagService.addTagToQuestion(addedTag, newQuestion);
					} else {
						System.out.println("This Tag exists " + tag);
						Tag getTag = tagService.findTagBySubject(tag);
						tagService.addTagToQuestion(getTag, newQuestion);					
					}
				}
				return "redirect:/questions";	
			}	
		}
	
	@GetMapping("/questions/{questionId}")
	public String showQ (@PathVariable("questionId") Long id, @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
			Question thisQuestion = questionService.findQuestionById(id);
			model.addAttribute("question", thisQuestion);
			return "QuestionDetails.jsp";
	}
	
	@PostMapping("/questions/{questionId}")
	public String addAnswer (@PathVariable("questionId") Long id, @Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "QuestionDetails.jsp";		
		}else {
			answerService.createAnswer(answer);
			return "redirect:/questions/" + id;
		}
	}

}
