package com.cydeo.loosely;

import java.math.BigDecimal;

public class BalanceManager {

    public boolean checkout(Balance balance, BigDecimal checkoutAmount) {

        return balance.getAmount().subtract(checkoutAmount).compareTo(BigDecimal.ZERO) > 0;
    }
}
