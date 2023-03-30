package com.example.ConfigClient.rest;

import com.example.ConfigClient.model.BankAccount;
import com.example.ConfigClient.service.BankAccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping("/bank")
public class BankAccountController {

    @Autowired
    public BankAccountService bankAccountService;

    @PostMapping("/create")
    public ResponseEntity<?> createBankAccount(@RequestBody BankAccount bankAccount, HttpServletRequest request) throws URISyntaxException {
        bankAccountService.createBankAccount(bankAccount);
        log.info("Created bank account {}", bankAccount);

        URI uri = new URI(request.getRequestURL() + "bank/" + bankAccount.getAccountId());

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<BankAccount> getBankAccount(@PathVariable("accountId") String accountId){
        BankAccount account = bankAccountService.retrieveBankAccount(accountId);

        log.info("Retrieved bank account {}", account);

        return ResponseEntity.ok(account);
    }
}
