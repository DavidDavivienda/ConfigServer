package com.example.ConfigClient.service;

import com.example.ConfigClient.config.Configuration;
import com.example.ConfigClient.model.BankAccount;
import com.example.ConfigClient.model.EnumAccountType;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankAccountService {

    @Autowired
    private Configuration configuration;

    private Map<String, BankAccount> accountCache = new HashMap<>();

    @PostConstruct
    public void setUpTestData() {
        BankAccount account1 = new BankAccount("AI123", "David Salas", BigDecimal.valueOf(1250.38), EnumAccountType.CURRENT_ACCOUNT);
        BankAccount account2 = new BankAccount("AI156", "David Salas", BigDecimal.valueOf(1550.38), EnumAccountType.SAVINGS_ACCOUNT);

        accountCache.put(account1.getAccountId(), account1);
        accountCache.put(account2.getAccountId(), account2);
    }

    public void createBankAccount (BankAccount account){
        if (account.getAccountBalance().doubleValue() >= configuration.getMinBalance() &&
                account.getAccountBalance().doubleValue() <= configuration.getMaxBalance()){
            accountCache.put(account.getAccountId(), account);
        }
        else {
            throw new InvalidAccountBalanceException("Bank Account balance is outside of allowed thresholds");
        }
    }

    public BankAccount retrieveBankAccount(String accountId){
        return accountCache.get(accountId);
    }
}
