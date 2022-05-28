package baekjoon.Q10870;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int[] fibonacci = new int[21];
        fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }
        System.out.println(fibonacci[new Scanner(System.in).nextInt()]);
    }

}
