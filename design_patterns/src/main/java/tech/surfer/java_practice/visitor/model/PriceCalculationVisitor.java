package tech.surfer.java_practice.visitor.model;

public interface PriceCalculationVisitor {

    public void visit(Item1 item1);

    public void visit(Item2 item2);
}
