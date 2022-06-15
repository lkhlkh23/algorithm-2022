package baekjoon.Q17086;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // not completed (BFS)

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

        /*for (int j = 0; j < maps.length; j++) {
            for (int k = 0; k < maps[0].length; k++) {
                System.out.print(maps[j][k] + "  ");
            }
            System.out.println();
        }*/

        int max = -1;
        for (int i = 0; i < maps[0].length; i++) {
            final int[][] result = init(maps[0].length, maps.length);
            final boolean[][] visited = new boolean[maps.length][maps[0].length];
            bfs(maps, visited, result, new Point(i, 0));

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < maps.length; j++) {
                for (int k = 0; k < maps[0].length; k++) {
                    if(j == 0 && k == i) {
                        continue;
                    }
                    if(maps[j][k] == 1) {
                        min = Math.min(result[j][k], min);
                       //  System.out.println(min + "@@@");
                    }
                }
            }

            /*System.out.println("----------------------------------------");
            for (int[] ints : result) {
                for (int anInt : ints) {
                    System.out.print(anInt);
                }
                System.out.println();
            }
            System.out.println("----------------------------------------");*/
            //System.out.println(min + "~~");
            max = Math.max(min, max);
        }

        System.out.println(max);
    }

    private static int[][] init(final int xSize, final int ySize) {
        final int[][] result = new int[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }

        return result;
    }

    // visited 필요
    private static void bfs(final int[][] maps, final boolean[][] visited, final int[][] result, final Point point) {
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

                visited[poll.y][poll.x] = true;
                result[poll.y][poll.x] = Math.min(len, result[poll.y][poll.x]);
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
