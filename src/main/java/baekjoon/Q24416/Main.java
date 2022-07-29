package baekjoon.Q24416;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int n = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println(fib(n) + " " + (n <= 2 ? 1 : n - 2));
    }

    private static int fib(final int n) {
        if(n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

}
