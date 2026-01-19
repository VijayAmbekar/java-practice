package tech.surfer.design_patterns.visitor;

public class DiscountPriceVisitor implements PriceCalculationVisitor {
    @Override
    public double visit(Item1 item1) {
        //plain discount calculation
        return item1.getPrice() - (item1.getPrice()* item1.getDiscountRate()/100);
    }

    @Override
    public double visit(Item2 item2) {
        //discount applies only if price is above 100
        double disc = item2.getPrice() > 100 ? (item2.getPrice() * item2.getDiscountRate()/100) : 0;
        return item2.getPrice() - disc;
    }
}
