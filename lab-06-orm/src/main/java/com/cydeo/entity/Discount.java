package com.cydeo.entity;

import com.cydeo.eums.DiscountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Discount extends BaseEntity {

    // (discount, discount_type, name)
    // VALUES (25.00, 'RATE_BASED', '%25');

    private double discount;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private String name;

}
