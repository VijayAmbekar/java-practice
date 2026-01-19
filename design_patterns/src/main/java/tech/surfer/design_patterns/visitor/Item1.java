package tech.surfer.design_patterns.visitor;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Item1  extends ShoppingItem {

    public double price;
    public double discountRate;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double accept(PriceCalculationVisitor priceCalculationVisitor) {
        return priceCalculationVisitor.visit(this);
    }
}
