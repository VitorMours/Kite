package com.vprofit.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vprofit.backend.models.Expense;
import com.vprofit.backend.repositories.ExpenseRepository;

@Service
public class ExpenseService {
  
  @Autowired 
  private ExpenseRepository expenseRepository;

  public List<Expense> getAll(){
    List<Expense> expenses = expenseRepository.findAll();
    return expenses;
  }

  public Expense getById(Long id){
    Expense expenses = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
    return expenses;
  }

  public Expense create(Expense expense){
    return expenseRepository.save(expense);
  }
}
