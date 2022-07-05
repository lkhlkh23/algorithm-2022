package baekjoon.Q11058;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(dp(Integer.parseInt(new Scanner(System.in).nextLine())));
    }

    public static long dp(final int n) {
        final long[] count = new long[100 + 1];
        for (int i = 1; i <= 6; i++) {
            count[i] = i;
        }

        for (int i = 7; i < count.length; i++) {
            // count[7] = count[4] + count[4] * 1 = 8
            // count[7] = count[3] + count[3] * 2 = 9
            // count[7] = count[2] + count[2] * 3 = 8
            // count[7] = count[1] + count[1] * 4 = 5
            // count[i] = count[i - (2 + j)] * (j + 1)
            for (int j = 1; j <= i - 3; j++) {
                count[i] = Math.max(count[i], count[j] + count[j] * (i - (j + 2)));
            }
        }

        return count[n];
    }

}



