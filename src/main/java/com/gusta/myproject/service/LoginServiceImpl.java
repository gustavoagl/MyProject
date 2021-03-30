/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusta.MyProject.service;

import com.gusta.MyProject.Repository.LoginRepository;
import com.gusta.MyProject.dto.LoginRegisterDto;
import com.gusta.MyProject.entity.Login;
import com.gusta.MyProject.entity.Role;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gustavo
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired(required = true)
    private LoginRepository loginRepository;

   

    public Login findByEmail(String email) {
        return loginRepository.findByEmail(email);
    }

    public Login save(LoginRegisterDto register) {
        Login login = new Login();
        login.setName(register.getName());
        login.setLastName(register.getLastName());
        login.setEmail(register.getEmail());
        login.setPassword(register.getPassword());
        login.setTelefone(register.getTelefone());
        return loginRepository.save(login);
    }

    @Override
    public void saveLogin(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login findByName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login user = loginRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getNome()))
                .collect(Collectors.toList());
    }

}
