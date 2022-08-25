package baekjoon.Q17298;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final String[] inputs = scanner.nextLine().split(" ");
        final Stack<Integer> stack = new Stack<>();
        final Stack<Integer> temp = new Stack<>();
        for (int i = inputs.length - 1; i >= 0; i--) {
            final int num = Integer.parseInt(inputs[i]);
            if(stack.isEmpty()) {
                stack.push(-1);
                temp.push(num);
                continue;
            }

            int pop = -1;
            while ((pop = temp.peek()) <= num) {
                temp.pop();
                if(temp.isEmpty()) {
                    pop = -1;
                    break;
                }
            }
            stack.push(pop);
            temp.push(num);
        }

        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb.toString());
    }

}
