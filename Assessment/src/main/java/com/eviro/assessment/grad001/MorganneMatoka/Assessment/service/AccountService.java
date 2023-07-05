package com.eviro.assessment.grad001.MorganneMatoka.Assessment.service;



import com.eviro.assessment.grad001.MorganneMatoka.Assessment.entity.AccountProfile;
import com.eviro.assessment.grad001.MorganneMatoka.Assessment.repository.AccountProfileRepository;
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