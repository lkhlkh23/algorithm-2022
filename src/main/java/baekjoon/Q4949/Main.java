package baekjoon.Q4949;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!".".equals(input = scanner.nextLine())) {
            final Stack<Character> stack = new Stack<>();
            final char[] inputs = input.toCharArray();
            for (final char c : inputs) {
                if(c != '[' && c != ']' && c != '(' && c != ')') {
                    continue;
                }

                if(stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if(stack.peek() == '(' && c == ')') {
                    stack.pop();
                    continue;
                }

                if(stack.peek() == '[' && c == ']') {
                    stack.pop();
                    continue;
                }

                stack.push(c);
            }

            System.out.println(stack.isEmpty() ? "yes" : "no");
        }
    }

}
