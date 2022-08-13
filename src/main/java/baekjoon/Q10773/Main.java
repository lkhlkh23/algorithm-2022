package baekjoon.Q10773;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final Stack<Integer> nos = new Stack<>();
        for (int i = 0; i < n; i++) {
            final int no = Integer.parseInt(scanner.nextLine());
            if(no == 0 && !nos.isEmpty()) {
                nos.pop();
            } else {
                nos.push(no);
            }
        }

        int sum = 0;
        for (final Integer no : nos) {
            sum += no;
        }

        System.out.println(sum);
    }

}
