package baekjoon.Q15989;

import java.util.Scanner;

public class Main {

    // not completed (금)

    public static void main(String[] args) {
        final int[] seconds = new int[10000 + 1]; // 1,2
        for (int i = 1; i < seconds.length; i++) {
            seconds[i] = (i / 2) + 1;
        }

        final int[] thirds = new int[10000 + 1]; // 1, 2, 3
        thirds[1] = 1;
        thirds[2] = 2;
        thirds[3] = 3;

        for (int i = 4; i < thirds.length; i++) {
            thirds[i] = seconds[i - 2] + thirds[i - 3] + 1;
        }

        final Scanner scanner = new Scanner(System.in);
        final int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            System.out.println(thirds[Integer.parseInt(scanner.nextLine())]);
        }
    }
}
