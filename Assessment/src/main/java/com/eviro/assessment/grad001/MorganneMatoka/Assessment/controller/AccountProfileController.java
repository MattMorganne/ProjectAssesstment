package com.eviro.assessment.grad001.MorganneMatoka.Assessment.controller;

import com.eviro.assessment.grad001.MorganneMatoka.Assessment.entity.AccountProfile;
import com.eviro.assessment.grad001.MorganneMatoka.Assessment.repository.AccountProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountProfileController {

    private final AccountProfileRepository accountProfileRepository;

    @Autowired
    public AccountProfileController(AccountProfileRepository accountProfileRepository) {
        this.accountProfileRepository = accountProfileRepository;
    }

    @GetMapping("/displayAccount")
    public String displayAccountProfiles(Model model) {
        List<AccountProfile> accountProfiles = accountProfileRepository.findAll();
        model.addAttribute("accountProfiles", accountProfiles);

        return "display";
    }
}
