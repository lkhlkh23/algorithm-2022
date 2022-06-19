package baekjoon.Q13913;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        final String[] inputs = new Scanner(System.in).nextLine().split(" ");
        final int n = Integer.parseInt(inputs[0]);
        final int k = Integer.parseInt(inputs[1]);

        final List<Integer> result = bfs(n, k);
        System.out.println(result.size() - 1);
        for (final Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    private static List<Integer> bfs(final int n, final int k) {
        // 이 부분을 고려하지 않으면 타임아웃 발생!
        if(n > k) {
            return IntStream.range(k, n + 1)
                            .boxed()
                            .sorted(Collections.reverseOrder())
                            .collect(Collectors.toList());
        }

        final boolean[] visited = new boolean[100000 + 1];
        final Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(n, new ArrayList<>()));
        while (!queue.isEmpty()) {
            final Point poll = queue.poll();
            if(poll.position == k) {
                poll.commands.add(poll.position);
                return poll.commands;
            }

            if(poll.position < 0 || poll.position >= visited.length || visited[poll.position]) {
                continue;
            }

            visited[poll.position] = true;
            poll.commands.add(poll.position);

            queue.offer(new Point(poll.position * 2, poll.commands));
            queue.offer(new Point(poll.position + 1, poll.commands));
            queue.offer(new Point(poll.position - 1, poll.commands));
        }

        return new ArrayList<>();
    }

    private static class Point {
        private int position;
        private List<Integer> commands;

        public Point(final int position, final List<Integer> commands) {
            this.position = position;
            this.commands = new ArrayList<>(commands);
        }
    }

}
