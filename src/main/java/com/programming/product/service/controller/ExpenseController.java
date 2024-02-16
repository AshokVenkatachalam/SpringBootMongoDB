package com.programming.product.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programming.product.service.impleservice.ExpenseService;
import com.programming.product.service.model.Expense;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	
	private final ExpenseService expenseService;
	
	
	
	public ExpenseController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}

	@PostMapping
	public ResponseEntity addExpense(@RequestBody Expense expenses) {
		
		expenseService.addExpense(expenses);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> updateExpense(Expense expense) {
		
		System.out.println(expense.getId());
		expenseService.updateExpense(expense);
		return ResponseEntity.ok().build();
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpense() {
		
	
		return ResponseEntity.ok(expenseService.getAllExpense());
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
		
		return ResponseEntity.ok(expenseService.getExpenseByName(name));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteExpense(@PathVariable String id) {
		
		expenseService.deleteExpense(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}

}
