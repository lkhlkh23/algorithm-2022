package baekjoon.Q15988;

import java.util.Scanner;

public class Main {

    // completed (목)

    public static void main(String[] args) {
        final long[] nos = new long[1000000 + 1];
        nos[1] = 1;
        nos[2] = 2;
        nos[3] = 4;
        for (int i = 4; i < nos.length; i++) {
            nos[i] = (nos[i - 1] + nos[i - 2] + nos[i - 3]) % 1000000009;
        }

        final Scanner scanner = new Scanner(System.in);
        final int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            System.out.println(nos[Integer.parseInt(scanner.nextLine())]);
        }
    }

}
