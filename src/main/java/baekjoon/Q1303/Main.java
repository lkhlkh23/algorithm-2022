package baekjoon.Q1303;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] first = scanner.nextLine().split(" ");
        final char[][] map = new char[Integer.parseInt(first[1])][Integer.parseInt(first[0])];
        for (int i = 0; i < map.length; i++) {
            final char[] inputs = scanner.nextLine().toCharArray();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = inputs[j];
            }
        }

        System.out.println(getPower(map, 'W') + " " + getPower(map, 'B'));
    }

    private static int getPower(final char[][] map, final char enemy) {
        int sum = 0;
        final boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                final Soldier soldier = new Soldier();
                fight(map, visited, j, i, soldier, enemy);
                sum += (soldier.count * soldier.count);
            }
        }

        return sum;
    }

    private static void fight(final char[][] map, final boolean[][] visited, final int x, final int y, final Soldier soldier, final char c) {
        // 1. 배열 밖으로 넘어가는지 체크
        if(x < 0 || x >= map[0].length || y < 0 || y >= map.length) {
            return;
        }

        // 2. 아군인지 체크 + 방문했는지 체크
        if(map[y][x] != c || visited[y][x]) {
            return;
        }

        // 3. 방문 처리
        visited[y][x] = true;

        // 4. 아군의 수 증가 처리
        soldier.count++;

        // 5. 동, 서, 남, 북으로 이동
        fight(map, visited, x + 1, y, soldier, c);
        fight(map, visited, x - 1, y, soldier, c);
        fight(map, visited, x, y + 1, soldier, c);
        fight(map, visited, x, y - 1, soldier, c);
    }

    private static class Soldier {
        private int count;
    }

}
