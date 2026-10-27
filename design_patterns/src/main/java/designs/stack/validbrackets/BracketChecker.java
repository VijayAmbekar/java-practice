package designs.stack.validbrackets;

import designs.stack.ArrayStack;

import java.util.stream.IntStream;

public class BracketChecker {


    private char[] closingBrackets = new char[]{']', '}', ')', '>'};
    private char[] openingBrackets = new char[]{'[', '{', '(', '<'};


    public boolean isValidBrackets(String str) {
        ArrayStack<Character> stack = new ArrayStack(str.length());
        boolean isValid = true;

        /**
         * 1. put elements one by one
         * 2. Before adding check
         *      1. If this is closing bracket
         *          Yes?
         *             - If stack is empty -> invalid string
         *             - If stack has content
         *                  - If top contain corresponding opening element
         *                      Yes? - pop the top and dont insert current
         *                      No? - invalid string
         *        No? -
         *
         *
         */

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            boolean isClosing = partOfIt(c, closingBrackets);
            if (isClosing) {
                if (stack.isEmpty()) {
                    System.out.print("Cannot add closing bracket in empty stack directly");
                    isValid = false;
                    break;
                }

                char topElement = stack.peek();
                if (isMatchingBracket(c, topElement)) {
                    // pop the top
                    stack.pop();
                    continue;
                }

                System.out.print("This is invalid string as brackets dont match");
                isValid = false;
                break;
            } else {
                stack.push(c);
            }
        }

        return isValid;

    }

    private boolean partOfIt(char s, char[] brackets) {
        IntStream intStream = new String(brackets).chars();
        return intStream.anyMatch(i -> i == s);
    }

    private boolean isMatchingBracket(char currentBracket, char stackTop) {
        System.out.print("current: " + currentBracket + "top:" + stackTop);
        return (currentBracket == ']' && stackTop == '[') ||
                (currentBracket == '}' && stackTop == '{') ||
                (currentBracket == '>' && stackTop == '<') ||
                (currentBracket == ')' && stackTop == '(');
    }

}
