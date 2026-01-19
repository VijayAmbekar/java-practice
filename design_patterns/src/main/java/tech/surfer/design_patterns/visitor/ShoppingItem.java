package tech.surfer.design_patterns.visitor;

import lombok.*;

@Getter
@Setter
@ToString
public abstract class ShoppingItem {

    public abstract double accept(PriceCalculationVisitor priceCalculationVisitor);
}
