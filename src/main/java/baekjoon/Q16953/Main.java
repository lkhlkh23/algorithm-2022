package baekjoon.Q16953;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // completed

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] input = scanner.nextLine().split(" ");
        final int a = Integer.parseInt(input[0]);
        final int b = Integer.parseInt(input[1]);

        final List<Count> counts = new ArrayList<>();
        calculate(a, b, new Count(), counts);

        int min = Integer.MAX_VALUE;
        for (final Count count : counts) {
            min = Math.min(count.cnt, min);
        }

        System.out.println(counts.isEmpty() ? -1 : min);
    }

    private static void calculate(final long a, final int b, final Count count, final List<Count> counts) {
        if(a == b) {
            counts.add(count);
            return;
        }

        if(a > b) {
            return;
        }

        final Count copied = new Count(count);

        calculate(a * 2, b, copied, counts);
        calculate(Long.parseLong(a + "1"), b, copied, counts);
    }

    private static class Count {

        private int cnt = 1;

        public Count() {

        }

        public Count (final Count count) {
            this.cnt = count.cnt + 1;
        }

    }
}
