package baekjoon.Q11660;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        final int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            final int startX = scanner.nextInt();
            final int startY = scanner.nextInt();
            final int endX = scanner.nextInt();
            final int endY = scanner.nextInt();

            for (int j = startY - 1; j < endY; j++) {
                for (int k = startX - 1; k < endX; k++) {
                    sum += arr[j][k];
                }
            }

            System.out.println(sum);
        }
    }
}
