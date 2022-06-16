package baekjoon.Q13549;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] inputs = scanner.nextLine().split(" ");

        System.out.println(bfs(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
    }

    private static int bfs(final int n, final int k) {
        // 수빈이가 동생보다 직선상에서 더 앞설 수 있을 때, only -1 이동만 가능
        if(n >= k) {
            return n - k;
        }

        // 우선순위큐를 사용하는 이유는 visited를 방문을 남기는데...
        // 1 -> 2 가 되는것은 *2 +1 이 될 수 있다. 그러나 +1이 되면 1초가 흐르기 때문에! 이런 케이스가 발생할 수 있기 때문에 *2를 최우선으로 하는게 좋다!
        final PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(n, 0));

        final boolean[] visited = new boolean[100000 + 1];
        while (!queue.isEmpty()) {
            final Point point = queue.poll();
            if(point.position == k) {
                return point.cnt;
            }

            if(point.position >= visited.length || point.position < 0 || visited[point.position]) {
                continue;
            }

            visited[point.position] = true;

            queue.offer(new Point(point.position * 2, point.cnt));
            queue.offer(new Point(point.position + 1, point.cnt + 1));
            queue.offer(new Point(point.position - 1, point.cnt + 1));
        }

        return 0;
    }

    private static class Point  implements Comparable<Point> {

        private int position;
        private int cnt;

        public Point(final int position, final int cnt) {
            this.position = position;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(final Point point) {
            return this.cnt - point.cnt;
        }
    }

}
