package com.example.ConfigClient.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class BankAccount {

    private String accountId;
    private String accountName;
    private BigDecimal accountBalance;
    private EnumAccountType accountTYpe;
}
