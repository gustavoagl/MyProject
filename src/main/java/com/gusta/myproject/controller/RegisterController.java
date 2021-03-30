/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusta.MyProject.LoginController;

import com.gusta.MyProject.Repository.LoginRepository;
import com.gusta.MyProject.dto.LoginRegisterDto;
import com.gusta.MyProject.entity.Login;
import com.gusta.MyProject.service.LoginService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Gustavo
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    
      @Autowired
    private LoginService loginService;

    @ModelAttribute("login")
    public LoginRegisterDto loginRegisterDto() {
        return new LoginRegisterDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "register";
    }

    
    @PostMapping
    public String registerUserAccount(@ModelAttribute("login") @Valid LoginRegisterDto loginDto,
        BindingResult result) {

        Login existing = loginService.findByEmail(loginDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "register";
        }
        loginService.save(loginDto);
        return "redirect:/register?success";
    }
    
}


 