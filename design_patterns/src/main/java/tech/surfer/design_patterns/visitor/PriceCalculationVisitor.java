package tech.surfer.design_patterns.visitor;

public interface PriceCalculationVisitor {

    public double visit(Item1 item1);

    public double visit(Item2 item2);
}
