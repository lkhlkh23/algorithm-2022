package baekjoon.Q12851;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final String[] inputs = new Scanner(System.in).nextLine().split(" ");
        final int n = Integer.parseInt(inputs[0]);
        final int k = Integer.parseInt(inputs[1]);

        final List<Integer> results = bfs(n, k).stream().sorted().collect(Collectors.toList());
        final int time = results.get(0);
        System.out.println(time);
        System.out.println(results.stream().filter(c -> c == time).count());
    }

    private static List<Integer> bfs(final int n, final int k) {
        if(n > k) {
            return List.of(n - k);
        }

        final List<Integer> results = new ArrayList<>();
        final boolean[] visited = new boolean[100000 + 1];
        final Queue<Point> queue = new LinkedList<>();
        final Queue<Point> temps = new LinkedList<>();
        queue.add(new Point(n, 0));
        while(!queue.isEmpty()) {
            final Point point = queue.poll();
            if(point.position == k) {
                results.add(point.cnt);
            }

            temps.add(new Point(point.position * 2, point.cnt + 1));
            temps.add(new Point(point.position + 1, point.cnt + 1));
            temps.add(new Point(point.position - 1, point.cnt + 1));

            if(queue.isEmpty()) {
                final List<Integer> positions = new ArrayList<>();
                while(!temps.isEmpty()) {
                    final Point temp = temps.poll();
                    if(temp.position < 0 || temp.position >= visited.length || visited[temp.position]) {
                        continue;
                    }

                    positions.add(temp.position);
                    queue.add(temp);
                }

                // (0 3) (+1 +1 +1) (+1 *2 +1) 를 모두 충족시키기 위해서!
                for (final int position : positions) {
                    visited[position] = true;
                }
            }
        }

        return results;
    }

    private static class Point {
        private int position;
        private int cnt;

        public Point(int position, int cnt) {
            this.position = position;
            this.cnt = cnt;
        }
    }
}
