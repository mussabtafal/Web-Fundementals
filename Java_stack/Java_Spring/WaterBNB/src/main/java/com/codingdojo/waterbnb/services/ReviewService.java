package com.codingdojo.waterbnb.services;

import org.springframework.stereotype.Service;

import com.codingdojo.waterbnb.repositories.ReviewRepository;

@Service
public class ReviewService {

	private final ReviewRepository reviewRepository;

	public ReviewService(ReviewRepository reviewRepository) {
		super();
		this.reviewRepository = reviewRepository;
	}
	
	
	
}
