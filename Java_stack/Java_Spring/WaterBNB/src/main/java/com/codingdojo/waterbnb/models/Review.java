package com.codingdojo.waterbnb.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="Review is required!")
    @Size(min=10, message="Review must be atleast 10 characters")
    private String text;
    
    @NotEmpty(message="Rating is required!")
    private Integer rating;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reviewUser_id")
	private User reviewUser;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reviewListing_id")
	private Listing reviewListing;
	
	public Review() {
	}
	public Review(String text, Integer rating) {
		this.text = text;
		this.rating = rating;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public User getReviewUser() {
		return reviewUser;
	}
	public void setReviewUser(User reviewUser) {
		this.reviewUser = reviewUser;
	}
	public Listing getReviewListing() {
		return reviewListing;
	}
	public void setReviewListing(Listing reviewListing) {
		this.reviewListing = reviewListing;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	   
    
}
