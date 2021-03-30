/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusta.MyProject.dto;

/**
 *
 * @author Gustavo
 */
public class LoginRegisterDto {

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String telefone;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
