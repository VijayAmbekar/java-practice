package tech.surfer.design_patterns.visitor;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Item2 extends ShoppingItem {

    public double price;
    public double discountRate;
    @Override
    public double accept(PriceCalculationVisitor priceCalculationVisitor) {
        return priceCalculationVisitor.visit(this);
    }
}
