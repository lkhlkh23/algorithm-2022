package baekjoon.Q1018;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] sizes = scanner.nextLine().split(" ");
        char[][] chess = new char[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        for (int i = 0; i < chess.length; i++) {
            final char[] inputs = scanner.nextLine().toCharArray();
            chess[i] = inputs;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= chess.length - 8; i++) {
            for (int j = 0; j <= chess[0].length - 8; j++) {
                min = Math.min(getMinFlip(extract(chess, j, i)), min);
            }
        }

        System.out.println(min);
    }

    private static char[][] extract(final char[][] origin, final int x, final int y) {
        final char[][] copy = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                copy[i][j] = origin[y + i][x + j];
            }
        }

        return copy;
    }

    private static int getMinFlip(final char[][] chess) {
        final StringBuilder black = new StringBuilder();
        for (int i = 0; i < chess[0].length; i++) {
            black.append(i % 2 == 0 ? "B" : "W");
        }

        final StringBuilder white = new StringBuilder();
        for (int i = 0; i < chess[0].length; i++) {
            white.append(i % 2 == 0 ? "W" : "B");
        }

        int blackCount = 0;
        for (int i = 0; i < chess.length; i++) {
            final String compare = i % 2 == 0 ? black.toString() : white.toString();
            for (int j = 0; j < chess[0].length; j++) {
                if(compare.charAt(j) != chess[i][j]) {
                    blackCount++;
                }
            }
        }

        int whiteCount = 0;
        for (int i = 0; i < chess.length; i++) {
            final String compare = i % 2 == 0 ? white.toString() : black.toString();
            for (int j = 0; j < chess[0].length; j++) {
                if(compare.charAt(j) != chess[i][j]) {
                    whiteCount++;
                }
            }
        }

        return Math.min(blackCount, whiteCount);
    }
}
