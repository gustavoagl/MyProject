/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusta.MyProject.Repository;

import com.gusta.MyProject.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gustavo
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    public Login findByEmail(String email);

    public Login findByName(String name);
    
}
