/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusta.MyProject.service;

import com.gusta.MyProject.dto.LoginRegisterDto;
import com.gusta.MyProject.entity.Login;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gustavo
 */
@Service
public interface LoginService extends UserDetailsService {

    Login findByName(String nome);

    Login save(LoginRegisterDto register);

    public Login findByEmail(String email);

    public void saveLogin(Login login);

}
