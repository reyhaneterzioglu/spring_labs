package com.cydeo.loosely;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

public class GiftCardBalance extends Balance {

    public GiftCardBalance(UUID userId, BigDecimal amount) {
        super(userId, amount);
    }

    @Override
    public BigDecimal addBalance(BigDecimal amount) {

        BigDecimal bonusAmount = amount.multiply(BigDecimal.TEN).divide(new BigDecimal(100), MathContext.DECIMAL64);
        setAmount(getAmount().add(amount).add(bonusAmount));
        return getAmount();

    }
}
