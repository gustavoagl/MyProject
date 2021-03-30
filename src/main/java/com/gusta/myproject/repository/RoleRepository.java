/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gusta.MyProject.Repository;

import com.gusta.MyProject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gustavo
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>  {
    Role findByRole(String role);
    
}
