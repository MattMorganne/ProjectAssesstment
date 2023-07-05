/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eviro.assessment.grad001.MatokaMorganne.demo.repository;

import com.eviro.assessment.grad001.MatokaMorganne.demo.entity.AccountProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Morganne
 */
public interface AccountProfileRepository extends JpaRepository<AccountProfile, Long>{
    
    
}
