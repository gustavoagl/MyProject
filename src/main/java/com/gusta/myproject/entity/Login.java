/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusta.MyProject.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Gustavo
 */
@Entity
public class Login implements Serializable {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "name")
   private String name;
   @Column(name = "lastName")
   private String lastName;
   @Column(name = "password")
   private String password;
   @Column(name = "email")
   private String email;
   @Column(name = "telefone")
   private String telefone;
   
   
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "login_role", joinColumns = @JoinColumn(name = "login_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

       public Collection<Role> getRoles() {
        return roles;
    }

    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
   
}
