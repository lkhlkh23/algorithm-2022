package baekjoon.Q1748;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int n = Integer.parseInt(new Scanner(System.in).nextLine());
        int total = 0;
        for (int i = 0; i < String.valueOf(n).length() - 1; i++) {
            total += ((Math.pow(10, i + 1) - 1) - (Math.pow(10, i) - 1)) * (i + 1);
        }
        total += (n - Math.pow(10, String.valueOf(n).length() - 1) + 1) * String.valueOf(n).length();

        System.out.println(total);
    }

}
