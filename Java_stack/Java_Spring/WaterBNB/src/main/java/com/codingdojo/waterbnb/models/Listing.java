package com.codingdojo.waterbnb.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="listings")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="address is required!")
    @Size(min=10, message="address must be at least 10 characters")
    private String address;
    
    @NotEmpty(message="description is required!")
    @Size(min=10, message="description must be atleast 10 characters")
    private String description;
    
    private double cost;
    
    private double avg;
    
    @NotEmpty(message="Pool Size is required!")
    private String poolSize;
    
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
	@JoinColumn(name="host_id")
	private User host;
    
    @OneToMany(mappedBy="reviewListing", fetch = FetchType.LAZY)
    private List<Review> listingReviews;
	 
	
	public Listing() {
	}
	
	public Listing(String address,String description,double cost, String poolSize) {
		this.address = address;
		this.description = description;
		this.cost = cost;
		this.poolSize = poolSize;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getPoolSize() {
		return poolSize;
	}
	public void setPoolSize(String poolSize) {
		this.poolSize = poolSize;
	}
	
	
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}
	public List<Review> getListingReviews() {
		return listingReviews;
	}
	public void setListingReviews(List<Review> listingReviews) {
		this.listingReviews = listingReviews;
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
