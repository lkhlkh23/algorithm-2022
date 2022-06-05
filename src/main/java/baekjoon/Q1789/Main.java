package baekjoon.Q1789;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long n = Long.parseLong(new Scanner(System.in).nextLine());
        int i = 1;
        while (n > 0) {
            n -= (i++);
        }

        System.out.println(n == 0 ? i - 1 : i - 2);
    }

}
