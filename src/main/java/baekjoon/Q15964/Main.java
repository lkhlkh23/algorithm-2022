package baekjoon.Q15964;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String[] inputs = new Scanner(System.in).nextLine().split(" ");
        final long a = Integer.parseInt(inputs[0]);
        final long b = Integer.parseInt(inputs[1]);

        System.out.println((a + b) * (a - b));
    }
}
