package sde.sheet.practice.datastructures.stackandqueue;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        String expression = "[{";
        Stack<Character> charStack = new Stack();
        for (int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                charStack.push(ch);
            } else {
                Character compCh = charStack.peek();
                if ((compCh == '{' && ch == '}') ||
                        (compCh == '(' && ch == ')') ||
                        (compCh == '[' && ch == ']')
                ) {
                    charStack.pop();
                } else {
                    break;
                }
            }
        }
        System.out.println("is balanced = " + charStack.isEmpty());
    }
}
