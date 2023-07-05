package com.eviro.assessment.grad001.MatokaMorganne.demo;

import com.eviro.assessment.grad001.MatokaMorganne.demo.model.AccountProfile;
import com.eviro.assessment.grad001.MatokaMorganne.demo.model.AccountProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public class AccountProfileController {

    private final AccountProfileRepository accountProfileRepository;

    @Autowired
    public AccountProfileController(AccountProfileRepository accountProfileRepository) {
        this.accountProfileRepository = accountProfileRepository;
    }

    @GetMapping("/displayer")
    public String displayAccountProfiles(Model model) {
        List<AccountProfile> accountProfiles = accountProfileRepository.findAll();
        model.addAttribute("accountProfiles", accountProfiles);

        return "display";
       
    }
}
