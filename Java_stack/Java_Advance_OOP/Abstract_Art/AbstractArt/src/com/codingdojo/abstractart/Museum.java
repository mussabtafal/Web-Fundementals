package com.codingdojo.abstractart;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Painting painting1 = new Painting("The Scream", "Mohammed", "Scary", "Acrylic");
		Painting painting2 = new Painting("Dreamy Sky", "Ahmed", "Beautiful", "Watercolor");
		Painting painting3 = new Painting("Monaliza", "Picaso", "Women", "Oil");
		painting1.viewArt();
		painting2.viewArt();
		painting3.viewArt();
		
		Sculpture sculpture1 = new Sculpture("The man", "Mathew", "Majestic", "Marble");
		Sculpture sculpture2 = new Sculpture("Flying Angel", "Saint Marry", "Gracefull", "Bronze" );
		sculpture1.viewArt();
		sculpture2.viewArt();
		
		ArrayList<Art> museum = new ArrayList<Art>();
		museum.add(painting1);
		museum.add(painting2);
		museum.add(painting3);
		museum.add(sculpture1);
		museum.add(sculpture2);
		
		
		System.out.println(museum);
		
		Collections.shuffle(museum);
		 for (Art keys : museum){
			 keys.viewArt();
	        }	
		
		
	}

}
