package com.vprofit.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vprofit.backend.models.Account;
import com.vprofit.backend.services.AccountService;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("accounts") 
@RestController
public class AccountController {
  
  @Autowired 
  private AccountService accountService;

  @GetMapping 
  public ResponseEntity<List<Account>> getAllAccounts(){
    List<Account> accounts = accountService.getAll();
    return ResponseEntity.ok(accounts);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Account> getAccount(@PathVariable Long id){
    Account account = accountService.findById(id);
    return ResponseEntity.ok(account);
  }

  @PostMapping
  public ResponseEntity<Account> createAccount(@RequestBody Account newAccount){
    Account account = accountService.create(newAccount);
    return ResponseEntity.ok(account);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account newAccountData){
    Account updatedAccount = accountService.update(id, newAccountData);
    return ResponseEntity.ok(updatedAccount);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAccount(@PathVariable Long id){
    accountService.deactivate(id);
    return ResponseEntity.noContent().build();
  }
}
