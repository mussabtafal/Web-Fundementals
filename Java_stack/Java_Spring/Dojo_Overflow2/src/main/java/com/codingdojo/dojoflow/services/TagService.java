package com.codingdojo.dojoflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoflow.models.Question;
import com.codingdojo.dojoflow.models.Tag;
import com.codingdojo.dojoflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
//finding methods
	public List<Tag> allTags () {
		return tagRepository.findAll();
	}
	
	public Tag findTagBySubject (String subject) {
		Optional<Tag> thisTag = tagRepository.findBySubject(subject);
		if(thisTag.isPresent()) {
			return thisTag.get();
		} else {
			return null;
		}
	}
	
	public Boolean ifTagExistsBySubject (String subject) {
		return tagRepository.existsBySubject(subject);		
	}
	
	public Tag createTag (Tag tag) {
		return tagRepository.save(tag);
	}
	
	public Tag addTagToQuestion(Tag tag, Question question) {
		tag.getTagQuestions().add(question);
		return tagRepository.save(tag);
	}

}
