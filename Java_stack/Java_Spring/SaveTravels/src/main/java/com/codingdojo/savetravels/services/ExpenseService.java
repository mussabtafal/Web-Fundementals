package com.codingdojo.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.repositories.ExpenseRepository;


@Service
public class ExpenseService {
private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    // returns all the books
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    
    // creates an expense
    public Expense createExpense(Expense e) {
        return expenseRepository.save(e);
    }
    
    public Expense updateExpense(Long id, String name, String vendor, String description, Integer amount) {
		Expense expenseUpdate = this.findExpense(id); 
		if (expenseUpdate != null) {
			expenseUpdate.setName(name);
			expenseUpdate.setVendor(vendor);
			expenseUpdate.setDescription(description);
			expenseUpdate.setAmount(amount);
			
			return expenseRepository.save(expenseUpdate);
		}
		else {
			return null;
		}
	}
    
    public void updateExpense(Expense expense) {
  		Expense editedExpense = expenseRepository.findById(expense.getId()).orElse(null); 
  		assert editedExpense != null;
  		editedExpense.setName(expense.getName());
  		editedExpense.setVendor(expense.getVendor());
  		editedExpense.setDescription(expense.getDescription());
  		editedExpense.setAmount(expense.getAmount());
  			
  		expenseRepository.save(editedExpense);
  	}
    
    public void deleteExpense(Long id) {
  		Expense deleteExpense = expenseRepository.findById(id).orElse(null); 
  		expenseRepository.delete(deleteExpense);
  	}
    
  }
    
    
