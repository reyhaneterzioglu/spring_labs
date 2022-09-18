package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

    // way 1 : using the parameter
    @Bean
    public Current current(Currency currency) {
        Current current = new Current();
        current.setAccountId(UUID.randomUUID());
        current.setAmount(new BigDecimal(500));
        current.setCurrency(currency);
        return current;

    }

    // way 2 : using the @Bean method calling in another @Bean
    @Bean
    public Saving saving() {
        Saving saving = new Saving();
        saving.setAccountId(UUID.randomUUID());
        saving.setAmount(new BigDecimal(500));
        saving.setCurrency(currency());
        return saving;
    }

    @Bean
    public Currency currency() {
        return new Currency(); // you can add all args constructor to the currency and initialize with the fields
    }
}
