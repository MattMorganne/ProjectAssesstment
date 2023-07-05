/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eviro.assessment.grad001.MatokaMorganne.demo.controller;
import com.eviro.assessment.grad001.MatokaMorganne.demo.model.AccountProfile;
import com.eviro.assessment.grad001.MatokaMorganne.demo.model.AccountProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountProfileRepository accountProfileRepository;

    @Autowired
    public AccountService(AccountProfileRepository accountProfileRepository) {
        this.accountProfileRepository = accountProfileRepository;
    }

    public void addAccount(AccountProfile accountProfile) {
        accountProfileRepository.save(accountProfile);
    }
}