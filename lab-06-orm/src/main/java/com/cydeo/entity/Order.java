package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order extends BaseEntity{

    //INSERT INTO public.orders ( paid_price, total_price, cart_id, customer_id, payment_id)
    // VALUES (668.82, 2678.65, 868, 170, 26);

    private Double paidPrice;
    private Double totalPrice;
    @OneToOne
    private Cart cart;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Payment payment;
}
