package baekjoon.Q4963;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String inputs = "";
        while (!(inputs = scanner.nextLine()).equals("0 0")) {
            final String[] first = inputs.split(" ");
            final int[][] maps = new int[Integer.parseInt(first[1])][Integer.parseInt(first[0])];
            final boolean[][] visited = new boolean[maps.length][maps[0].length];
            for (int i = 0; i < maps.length; i++) {
                final String[] second = scanner.nextLine().split(" ");
                for (int j = 0; j < second.length; j++) {
                    maps[i][j] = Integer.parseInt(second[j]);
                }
            }

            int cnt = 0;
            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < maps[0].length; j++) {
                    cnt = dfs(maps, visited, new Point(j, i)) > 0 ? cnt + 1 : cnt;
                }
            }
            System.out.println(cnt);
        }
    }

    public static int dfs(final int[][] maps, final boolean[][] visited, final Point start) {
        final Stack<Point> points = new Stack<>();
        points.add(start);

        int cnt = 0;
        while(!points.isEmpty()) {
            final Point point = points.pop();
            if(point.y < 0 || point.y >= maps.length || point.x < 0 || point.x >= maps[0].length) {
                continue;
            }

            if(visited[point.y][point.x]) {
                continue;
            }

            if(maps[point.y][point.x] == 0) {
                continue;
            }

            visited[point.y][point.x] = true;
            cnt++;

            points.push(new Point(point.x, point.y - 1));
            points.push(new Point(point.x, point.y + 1));
            points.push(new Point(point.x - 1, point.y));
            points.push(new Point(point.x + 1, point.y));
            points.push(new Point(point.x - 1, point.y - 1));
            points.push(new Point(point.x + 1, point.y - 1));
            points.push(new Point(point.x - 1, point.y + 1));
            points.push(new Point(point.x + 1, point.y + 1));
        }

        return cnt;
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
