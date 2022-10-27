package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product extends BaseEntity{


    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;

    @JoinTable(name = "product_category_rel", joinColumns = @JoinColumn(name = "p_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
    @ManyToMany
    private List<Category> category;
}
