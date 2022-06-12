package baekjoon.Q1743;

import java.util.Scanner;

public class Main {

    // completed

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] firstLine = scanner.nextLine().split(" ");
        final boolean[][] map = new boolean[Integer.parseInt(firstLine[0])][Integer.parseInt(firstLine[1])];
        for (int i = 0; i < Integer.parseInt(firstLine[2]); i++) {
            final String[] inputs = scanner.nextLine().split(" ");
            map[Integer.parseInt(inputs[0]) - 1][Integer.parseInt(inputs[1]) - 1] = true;
        }

        int max = 0;
        final boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                final Trash trash = new Trash();
                collect(map, visited, j, i, trash);
                max = Math.max(trash.count, max);
            }
        }
        System.out.println(max);
    }

    public static void collect(final boolean[][] map, final boolean[][] visited, final int x, final int y, final Trash trash) {
        if(x < 0 || x >= map[0].length || y < 0 || y >= map.length) {
            return;
        }

        if(visited[y][x] || !map[y][x]) {
            return;
        }

        visited[y][x] = true;
        trash.count++;

        collect(map, visited, x + 1, y, trash);
        collect(map, visited, x - 1, y, trash);
        collect(map, visited, x, y + 1, trash);
        collect(map, visited, x, y - 1, trash);
    }

    private static class Trash {
        private int count;
    }

}
