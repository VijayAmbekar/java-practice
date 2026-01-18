package tech.surfer.java_practice.visitor;

import org.junit.jupiter.api.Test;
import tech.surfer.java_practice.visitor.model.Item1;
import tech.surfer.java_practice.visitor.model.Item2;
import tech.surfer.java_practice.visitor.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {

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
    }

}