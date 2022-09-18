package com.cydeo.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        UUID userID = UUID.randomUUID();

        BalanceManager balanceManager = new BalanceManager();

        //--------------------------------------------------------------------

        Balance customerBalance = new CustomerBalance(userID, BigDecimal.ZERO);

        customerBalance.addBalance(BigDecimal.valueOf(150));

        Boolean test = balanceManager.checkout(customerBalance, new BigDecimal("80"));

        System.out.println(test);

        Balance giftCardBalance = new GiftCardBalance(userID, BigDecimal.ZERO);

        giftCardBalance.addBalance(BigDecimal.valueOf(120));

        Boolean test2 = balanceManager.checkout(giftCardBalance, BigDecimal.valueOf(80));

        System.out.println(test2);

    }
}
