package com.eviro.assessment.grad001.MorganneMatoka.Assessment.controller;

import com.eviro.assessment.grad001.MorganneMatoka.Assessment.entity.AccountProfile;
import com.eviro.assessment.grad001.MorganneMatoka.Assessment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Morganne
 */

@RestController
@RequestMapping("/accounts")
public class AccountDBController {
    private final AccountService accountService;

    @Autowired
    public AccountDBController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public String createAccount(@RequestBody AccountProfile accountProfile) {
        accountService.addAccount(accountProfile);
        return "Account created successfully";
    }
}