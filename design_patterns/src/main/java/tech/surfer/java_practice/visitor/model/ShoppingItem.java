package tech.surfer.java_practice.visitor.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class ShoppingItem {

    private double price;
    private double discountRate;
}
