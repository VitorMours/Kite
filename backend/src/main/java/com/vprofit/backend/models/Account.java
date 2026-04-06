package com.vprofit.backend.models;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// TODO: Need to refactor

@Entity 
@Table(name="tb_account")
public class Account implements Serializable {

  public static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column 
  private String name; 
  
  @Column 
  private boolean multipleUsers;
  
  @Column
  private boolean isActive;

  @Column 
  private Date createdAt;
  
  @Column 
  private Date updatedAt;

  @ManyToOne(optional = false)
  @JoinColumn(nullable = false)
  private User user;

  protected Account() {}

  public Account(User user) {
    if(user == null || user.equals("")){
      throw new IllegalArgumentException("Account precisa ter um usuario para existir");
    }
    this.user = user;
    this.createdAt = new Date();
    this.updatedAt = new Date();
    this.isActive = true;
    this.multipleUsers = false;
  }

  // Getters e Setters 
  // Getters 
  public String getName() {
    return name;
  }
  public User getUser() {
    return user;
  }
  public boolean getIsActive(){
    return isActive;
  }
  public boolean getMultipleUsers(){
    return multipleUsers;
  }
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public Date getCreatedAt() {
    return createdAt;
  }

  // Setters 
  public void setName(String name) {
    if(name == null || name.equals("")){
      throw new IllegalArgumentException("O valor do nome da conta nao pode ser nulo ou vazio");
    }
    this.name = name;
  }
  public void setUser(User user) {
    if(user == null || user.equals("")){
      throw new IllegalArgumentException("O valor do usuario da conta nao pode ser nulo ou vazio");
    }
    this.user = user;
  }

  public void setIsActive(boolean newIsActive) {
    this.isActive = newIsActive;
  }

  public void setMultipleUsers(boolean multipleUsers) {
    this.multipleUsers = multipleUsers;
  }
 
  public void setCreatedAt(Date newCreatedAt) {
    if(newCreatedAt == null || newCreatedAt.equals("")){
      throw new IllegalArgumentException("O valor da data de criação da conta nao pode ser nulo ou vazio");
    }
    this.createdAt = newCreatedAt;
  }
  public void setUpdatedAt(Date newUpdatedAt) {
    if(newUpdatedAt == null || newUpdatedAt.equals("")){
      throw new IllegalArgumentException("O valor da data de atualização da conta nao pode ser nulo ou vazio");
    }
    this.updatedAt = newUpdatedAt;
  }
}
