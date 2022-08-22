package baekjoon.Q25304;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int total = scanner.nextInt();
        final int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (scanner.nextInt() * scanner.nextInt());
        }

        System.out.println(sum == total ? "Yes" : "No");
    }

}
