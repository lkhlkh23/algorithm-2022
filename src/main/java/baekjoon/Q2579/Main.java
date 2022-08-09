package baekjoon.Q2579;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    // not completed (메모리 초과) (bfs) (월)
    // 메모리제이션으로 다시 풀이 필요!

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final List<Integer> stairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stairs.add(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println(bfs(stairs));
    }

    private static int bfs(final List<Integer> stairs) {
        final Set<Point> visited = new HashSet<>();
        final Queue<Point> temps = new LinkedList<>();
        final Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, stairs.get(0), 1));
        queue.offer(new Point(1, stairs.get(1), 1));

        int max = -1;
        while(!queue.isEmpty()) {
            final Point poll = queue.poll();

            if(poll.index == stairs.size() - 1) {
                max = Math.max(max, poll.sum);
            }

            if(poll.cnt >= 3) {
                continue;
            }

            if(visited.contains(poll)) {
                continue;
            }

            visited.add(poll);

            if(poll.index + 1 < stairs.size()) {
                temps.offer(new Point(poll.index + 1, stairs.get(poll.index + 1) + poll.sum, poll.cnt + 1));
            }

            if(poll.index + 2 < stairs.size()) {
                temps.offer(new Point(poll.index + 2, stairs.get(poll.index + 2) + poll.sum, 1));
            }

            while(queue.isEmpty()) {
                queue.addAll(temps);
                temps.clear();
            }
        }

        return max;
    }

    private static class Point {
        private int index;
        private int sum;
        private int cnt;

        public Point(final int index, final int sum, final int cnt) {
            this.index = index;
            this.sum = sum;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return index == point.index && sum == point.sum && cnt == point.cnt;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, sum, cnt);
        }
    }
}
