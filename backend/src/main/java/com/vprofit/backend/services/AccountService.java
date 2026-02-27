package com.vprofit.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vprofit.backend.models.Account;
import com.vprofit.backend.repositories.AccountRepository;

@Service 
public class AccountService {
  
  @Autowired 
  private AccountRepository accountRepository;

  public List<Account> getAll(){
    return accountRepository.findAll();
  }

  public Account create(Account account){
    return accountRepository.save(account);
  }
  public Account findById(Long id){
    return accountRepository.findById(id).orElseThrow(
      () -> new RuntimeException("Account nao encontrada")
    );
  }

  public Account update(Long id, Account newData){
    Account account = accountRepository.findById(id).orElseThrow(
      () -> new RuntimeException("Account nao encontrada")
    );
    account.setName(newData.getName());
    account.setIsActive(newData.getIsActive());
    account.setMultipleUsers(newData.getMultipleUsers());
    account.setUser(newData.getUser());
    account.setUpdatedAt(newData.getUpdatedAt());
    return accountRepository.save(account);
  }

  // soft delete
  public Account deactivate(Long id){
    Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account nao encontrada"));
    account.setIsActive(false);
    accountRepository.save(account);
    return account;
  }

}
