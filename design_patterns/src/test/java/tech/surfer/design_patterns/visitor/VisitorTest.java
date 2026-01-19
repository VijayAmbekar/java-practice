package tech.surfer.design_patterns.visitor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class VisitorTest {

    @Test
    public void testVisitor() {
        List<ShoppingItem> items = new ArrayList<>();
        Item1 item1 = new Item1();
        item1.setPrice(100.0);
        item1.setDiscountRate(20.0);

        Item2 item2 = new Item2();
        item2.setPrice(100.0);
        item2.setDiscountRate(10.0);

        items.add(item1);
        items.add(item2);

        PriceCalculationVisitor priceCalculationVisitor = new DiscountPriceVisitor();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setItems(items);
        shoppingCart.setPriceCalculationVisitor(priceCalculationVisitor);

        double total = shoppingCart.calculateTotalPrice();

        assertEquals(180.0, total);

        item2.setPrice(200.0);

        assertEquals(260.0, shoppingCart.calculateTotalPrice());
    }

}