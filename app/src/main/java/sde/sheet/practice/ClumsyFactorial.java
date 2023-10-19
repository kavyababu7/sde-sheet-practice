package sde.sheet.practice;

import java.util.LinkedList;
import java.util.Queue;

public class ClumsyFactorial {
    public static void main(String[] args) {
        int n = 10;
        Queue<Character> operators = new LinkedList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        System.out.println();
        System.out.println(factorial(n, operators));
    }

    private static int factorial(int n, Queue<Character> operators) {

        if (n == 1) {
            return n;
        }
        Character operator = operators.remove();
        System.out.print(n);
        System.out.print( operator);
        operators.add(operator);
        switch (operator) {
            case '+':
                return n+ factorial(n-1, operators);
            case '-':
                return n- factorial(n-1, operators);
            case '*':
                return n* factorial(n-1, operators);
            case '/':
            default:
                return n/ factorial(n-1, operators);
        }
    }

}
