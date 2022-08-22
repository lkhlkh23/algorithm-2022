package baekjoon.Q5557;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    // not completed

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final List<Integer> nos = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
        System.out.println(dp(nos));
    }

    private static long dp(final List<Integer> nos) {
        final long[][] dps = new long[20 + 1][100 + 1];
        final Queue<No> queue = new LinkedList<>();
        final Queue<No> temps = new LinkedList<>();
        queue.add(new No(nos.get(0), 0, 0));

        while(!queue.isEmpty()) {
            final No no = queue.poll();

            if(no.index == 0) {
                dps[no.index][no.sum] = 1;
            } else {
                dps[no.index][no.sum] = dps[no.index - 1][no.sum - (nos.get(no.index - 1) * no.op)];
            }

            temps.offer(new No(no.index + 1, no.sum + nos.get(no.index + 1), 1));

        }

        return 0;
    }

    private static class No {
        private int sum;
        private int index;
        private int op;

        public No(final int sum, final int index, final int op) {
            this.sum = sum;
            this.index = index;
            this.op = op;
        }
    }
}
