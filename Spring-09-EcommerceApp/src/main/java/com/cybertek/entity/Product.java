package com.cybertek.entity;

import com.cybertek.enums.ProductCondition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Product extends BaseEntity {

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    private String volume;

    @Enumerated(EnumType.STRING)
    private ProductCondition productCondition ;

    public Product(String name, String description, String volume, ProductCondition productCondition) {
        this.name = name;
        this.description = description;
        this.volume = volume;
        this.productCondition = productCondition;
    }
}
