package designs.stack;

import designs.stack.validbrackets.BracketChecker;

public class TestClient {

    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(4);
        LinkedListStack stack = new LinkedListStack();
        stack.push("10");
        stack.push("20");
        stack.push("30");
        stack.push("40");
//        stack.push("50");


        System.out.println("Popped element");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

//        BracketChecker bracketChecker = new BracketChecker();
//        System.out.println("isValid: '[]' : " + bracketChecker.isValidBrackets("[]"));
//        System.out.println("isValid: '{[[]]()<>}' : " + bracketChecker.isValidBrackets("{[[]]()<>}"));
//        System.out.println("isValid: '[]{}()' : " + bracketChecker.isValidBrackets("[]{}()"));
//        System.out.println("isValid: '[<<>>]' : " + bracketChecker.isValidBrackets("[<<>>]"));
//        System.out.println("isValid: '[}{]' : " + bracketChecker.isValidBrackets("[}{]"));
    }
}
