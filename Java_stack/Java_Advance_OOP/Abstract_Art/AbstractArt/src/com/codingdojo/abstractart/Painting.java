package com.codingdojo.abstractart;

public class Painting extends Art {
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
		// TODO Auto-generated constructor stub
	}

	
	

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("The painting title is " + this.getTitle() + " , the author is " + this.getAuthor() + 
				" the painting is " + this.getDescription() + " and the painting type is " + this.getPaintType());
		
		
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

}
