package tech.surfer.design_patterns.visitor;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingCart {

    List<ShoppingItem> items;

    PriceCalculationVisitor priceCalculationVisitor;

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for(ShoppingItem item:items) {
            totalPrice += item.accept(priceCalculationVisitor);
        }

        return totalPrice;
    }
}
