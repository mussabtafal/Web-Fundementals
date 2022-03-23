package com.codingdojo.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.MainService;

@SpringBootApplication
@Controller
public class MainController {
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@GetMapping("products/new")
    public String Ninja(@ModelAttribute("product") Product product, Model model) {
		List<Product> allProducts = mainService.allProduct();
		model.addAttribute("products", allProducts);
        return "ProductForm.jsp";
    }
	
	@PostMapping("products/new")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "ProductForm.jsp";
        } else {
        	mainService.createProduct(product);
            return "redirect:/products/"+ product.getId();
        }
    }
	
	 @GetMapping("/products/{proid}")
	   public String showPro(@PathVariable("proid") Long id, Model model) {
		 Product thisProduct = mainService.findProduct(id);
	       model.addAttribute("pro", thisProduct);
	       model.addAttribute("allowedCat", mainService.availableCategoriesForProduct(thisProduct));
	       return "ShowProduct.jsp";
	   }
	
	   @GetMapping("/products/{proid}/relate")
	   public String showPro(@PathVariable("proid") Long id, @RequestParam("category") Long catId,  Model model) {
		   Product thisProduct = mainService.findProduct(id);
		    Category thisCategory= mainService.findCategory(catId);
		   mainService.addProduct(thisProduct, thisCategory);
		   
	       return "redirect:/products/" + id;
	   }
	
	@GetMapping("/categories/new")
    public String Category(@ModelAttribute("category") Category category) {
        return "CategoryForm.jsp";
    }
	
   @PostMapping("/categories/new")
    public String create(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "CategoryForm.jsp";
        } else {
        	mainService.createCategory(category);
        	model.addAttribute(category);
            return "redirect:/categories/"+ category.getId();
        }
    }
   
   @GetMapping("/categories/{catid}")
   public String showCat(@PathVariable("catid") Long id, Model model) {
	   Category thisCategory = mainService.findCategory(id);
       model.addAttribute("cat", thisCategory);
       model.addAttribute("allowedPro", mainService.availableProductsForCategory(thisCategory));
       return "ShowCategory.jsp";
   }
   
   @GetMapping("/categories/{catid}/relate")
   public String showCat(@PathVariable("catid") Long id, @RequestParam("product") Long proId,  Model model) {
	   Category thisCategory = mainService.findCategory(id);
	   Product thisProduct = mainService.findProduct(proId);
	   mainService.addProduct(thisProduct, thisCategory);
	   
       return "redirect:/categories/" + id;
   }
   
}
