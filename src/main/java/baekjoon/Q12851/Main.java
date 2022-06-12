package baekjoon.Q12851;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    // 시간초과

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] inputs = scanner.nextLine().split(" ");
        final int n = Integer.parseInt(inputs[0]);
        final int k = Integer.parseInt(inputs[1]);
        // 10 100 6
        // 100 1000
        // 방법1)
        // 5
        // *2 = 10
        // -1 = 9
        // *2 = 18
        // -1 = 17

        // 방법2)
        // 5
        // -1 = 4
        // *2 = 8
        // *2 = 16
        // +1 = 17

        final List<Integer> results = new ArrayList<>();
        final boolean[] visited = new boolean[100000 + 1];

        final Stack<Point> stack = new Stack();
        stack.add(new Point(n + 1));
        stack.add(new Point(n * 2));
        stack.add(new Point(n - 1));
        int min = Math.min((k - n), 30);
        while(!stack.isEmpty()) {
            final Point point = stack.pop();
            if(point.cnt > min) {
                continue;
            }

            if(point.position == k) {
                min = Math.min(point.cnt, min);
                results.add(point.cnt);
            }

            if(point.position < 0 || point.position > 100000) {
                continue;
            }

            if(!visited[point.position]) {
                stack.add(new Point(point.position - 1, point.cnt + 1));
                visited[point.position] = true;
            }
            stack.add(new Point(point.position + 1, point.cnt + 1));
            stack.add(new Point(point.position * 2, point.cnt + 1));
        }

        final int minMethod = results.stream().mapToInt(x -> x).min().getAsInt();
        final long duplicated = results.stream().filter(x -> x == minMethod).count();
        System.out.println(minMethod);
        System.out.println(duplicated);
    }

    private static class Point {

        private int position;
        private int cnt = 1;

        public Point(final int position) {
            this.position = position;
        }

        public Point(final int position, final int cnt) {
            this.position = position;
            this.cnt = cnt;
        }
    }

}
