package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Data
public class Address extends BaseEntity{

    private String name;
    private String street;
    private String zipCode;
    @ManyToOne
    private Customer customer;

}
