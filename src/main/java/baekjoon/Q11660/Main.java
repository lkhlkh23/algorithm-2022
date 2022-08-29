package baekjoon.Q11660;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder();
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        final int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + scanner.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            final int startY = scanner.nextInt();
            final int startX = scanner.nextInt();
            final int endY = scanner.nextInt();
            final int endX = scanner.nextInt();

            int sum = 0;
            for (int j = startY; j <= endY; j++) {
                sum += ((dp[j][endX] - dp[j][startX - 1]));
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }

}
