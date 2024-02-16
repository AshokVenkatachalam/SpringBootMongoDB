package com.programming.product.service.impleservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programming.product.service.model.Expense;
import com.programming.product.service.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	
	
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}

	public void addExpense(Expense expense) {
		
		expenseRepository.insert(expense);
	}
	
	public void updateExpense(Expense expense) {
		
		Expense SavedExpense=expenseRepository.findById(expense.getId())
				.orElseThrow(()-> new RuntimeException(String.format("Can not find expense by ID", expense.getId())));
		
		SavedExpense.setExpenseName(expense.getExpenseName());
		SavedExpense.setExpenseCategory(expense.getExpenseCategory());
		SavedExpense.setExpenseAmount(expense.getExpenseAmount());
		
		expenseRepository.save(SavedExpense);
	}
	
	public List<Expense> getAllExpense() {
		
		return expenseRepository.findAll();
		
	}
	
	public Expense getExpenseByName(String name) {
		
		return expenseRepository.findByName(name).orElseThrow(()-> new RuntimeException(
				String.format("Can Not Find Expense by name", name)));
		
	}
	
	public void deleteExpense(String id) {
		
		expenseRepository.deleteById(id);
		
	}

}
