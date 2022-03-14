package com.codingdojo.abstractart;

public class Sculpture extends Art {
	private String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("The Sculpture title is " + this.getTitle() + " , the author is " + this.getAuthor() + 
				" the Sculpture is " + this.getDescription() + " and made of " + this.getMaterial());
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
