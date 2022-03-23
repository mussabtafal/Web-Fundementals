package com.codingdojo.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;
import com.codingdojo.products.repositories.ProductRepository;



@Service
public class MainService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;

	
	 public MainService(CategoryRepository categoryRepository, ProductRepository productRepository) {
	        this.categoryRepository = categoryRepository;
	        this.productRepository = productRepository;
	    }
	 
//	 Category Specific Services		 
	 public List<Category> allCategories() {
	        return categoryRepository.findAll();
	    }
	 
	 public Category createCategory(Category e) {
	        return categoryRepository.save(e);
	    }
	 
	 public Category findCategory(Long id) {
	        Optional<Category> optionalCategory = categoryRepository.findById(id);
	        if(optionalCategory.isPresent()) {
	            return optionalCategory.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public Iterable<Product> availableProductsForCategory(Category category) {
			return productRepository.findByCategoriesNotContains(category);
		}
	 
	 public Category addProduct(Product e, Category c) {
		 c.getProducts().add(e);
	       return categoryRepository.save(c);
	    }
	 
	 
	 
//	 Product Specific Services	
	 public List<Product> allProduct() {
	        return productRepository.findAll();
	    }
	 
	 public Product createProduct(Product e) {
	        return productRepository.save(e);
	    }
	 
	 public Product findProduct(Long id) {
	        Optional<Product> optionalProduct = productRepository.findById(id);
	        if(optionalProduct.isPresent()) {
	            return optionalProduct.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public List<Category> availableCategoriesForProduct(Product product) {
	        return categoryRepository.findByProductsNotContains(product);  
	    }
	 
	 
	 public Product addCategory(Product e, Category c) {
		 e.getCategories().add(c);	
		 
	       return productRepository.save(e);
	    }
	 
	 
	
}
