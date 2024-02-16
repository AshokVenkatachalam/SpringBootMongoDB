package com.programming.product.service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.programming.product.service.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

	@Query("{'name': ?0}")
	Optional<Expense> findByName(String name);

}