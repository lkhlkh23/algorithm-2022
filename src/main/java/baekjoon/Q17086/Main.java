package baekjoon.Q17086;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] firstLine = scanner.nextLine().split(" ");
        final int[][] maps = new int[Integer.parseInt(firstLine[0])][Integer.parseInt(firstLine[1])];
        for (int i = 0; i < maps.length; i++) {
            final String[] inputs = scanner.nextLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                maps[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length ; j++) {
                if(maps[i][j] == 0) {
                    final boolean[][] visited = new boolean[maps.length][maps[0].length];
                    final int result = bfs(maps, visited, new Point(j, i));
                    max = Math.max(result, max);
                }
            }
        }

        System.out.println(max);
    }

    private static int bfs(final int[][] maps, final boolean[][] visited, final Point point) {
        final Queue<Point> queue = new LinkedList<>();
        final Queue<Point> temp = new LinkedList<>();
        queue.add(point);

        int len = 0;
        while(!queue.isEmpty()) {
            final Point poll = queue.poll();
            if(!(poll.x < 0 || poll.x >= maps[0].length || poll.y < 0 || poll.y >= maps.length)) {
                if(visited[poll.y][poll.x]) {
                    continue;
                }

                if(maps[poll.y][poll.x] == 1) {
                    return len;
                }

                visited[poll.y][poll.x] = true;

                temp.offer(new Point(poll.x - 1, poll.y - 1));
                temp.offer(new Point(poll.x, poll.y - 1));
                temp.offer(new Point(poll.x + 1, poll.y - 1));
                temp.offer(new Point(poll.x - 1, poll.y));
                temp.offer(new Point(poll.x + 1, poll.y));
                temp.offer(new Point(poll.x - 1, poll.y + 1));
                temp.offer(new Point(poll.x, poll.y + 1));
                temp.offer(new Point(poll.x + 1, poll.y + 1));
            }

            if(queue.isEmpty()) {
                queue.addAll(temp);
                temp.clear();
                len++;
            }
        }

        return 0;
    }

    private static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
