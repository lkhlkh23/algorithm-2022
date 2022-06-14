package baekjoon.Q17086;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // not completed

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

        int max = -1;
        for (int i = 2; i < 3; i++) {
            final boolean[][] visited = new boolean[maps.length][maps[0].length];
            final List<Count> counts = new ArrayList<>();
            find(maps, visited, i, 0, new Count(0), counts, true);
            counts.forEach(c -> System.out.println(c.cnt + "!!!!"));
            final int min = counts.stream().mapToInt(c -> c.cnt).min().getAsInt();
            //System.out.println(min + "~~~");
            max = Math.max(max, min);
        }

        System.out.println(max);
    }

    private static void find(final int[][] maps, final boolean[][] visited, final int x, final int y, final Count count, final List<Count> counts, final boolean isFirst) {
        if(x < 0 || x >= maps[0].length || y < 0 || y >= maps.length) {
            return;
        }

        if(visited[y][x]) {
            return;
        }

        if(maps[y][x] == 1 && !isFirst) {
            counts.add(count);
            return;
        }

        visited[y][x] = true;

        find(maps, visited, x - 1, y - 1, new Count(count.cnt + 1), counts, false);
        find(maps, visited, x, y - 1, new Count(count.cnt + 1), counts, false);
        find(maps, visited, x + 1, y - 1, new Count(count.cnt + 1), counts, false);
        find(maps, visited, x - 1, y, new Count(count.cnt + 1), counts, false);
        find(maps, visited, x + 1, y, new Count(count.cnt + 1), counts, false);
        find(maps, visited, x - 1, y + 1, new Count(count.cnt + 1), counts, false);
        find(maps, visited, x, y + 1, new Count(count.cnt + 1), counts, false);
        find(maps, visited, x + 1, y + 1, new Count(count.cnt + 1), counts, false);
    }

    private static class Count {

        private int cnt;

        public Count(final int cnt) {
            this.cnt = cnt;
        }
    }

}
