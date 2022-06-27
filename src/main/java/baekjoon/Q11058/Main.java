package baekjoon.Q11058;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    // not completed (월)
    // https://www.acmicpc.net/problem/11058
    // bfs - 메모리 초과

    public static void main(String[] args) {
        final int n = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println(bfs(n));
    }

    public static int bfs(final int n) {
        final Set<Board> visited = new HashSet<>();
        final Queue<Board> boards = new LinkedList<>();
        boards.offer(new Board(1, 0, 0, 1));

        int max = -1;
        while (!boards.isEmpty()) {
            final Board board = boards.poll();
            if(board.count == n) {
                max = Math.max(max, board.screen);
            }

            if(board.count > n) {
                continue;
            }

            if(visited.contains(board)) {
                continue;
            }

            visited.add(board);

            if(board.buffer < 1) {
                boards.offer(new Board(board.screen + 1, 0, board.buffer, board.count + 1)); // print
            }
            if(board.screen > board.buffer && board.count < (n - 1)) {
                boards.offer(new Board(board.screen, board.screen, 0, board.count + 1)); // ctrl A
            }
            if(board.selected > 0 && board.selected > board.buffer && board.count < n) {
                boards.offer(new Board(board.screen, board.selected, board.selected, board.count + 1)); // ctrl C
            }
            if(board.buffer > 1) {
                boards.offer(new Board(board.screen + board.buffer, 0, board.buffer, board.count + 1)); // ctrl V
            }
        }

        System.out.println(visited.size());

        return max;
    }

    private static class Board {

        private int screen;
        private int selected;
        private int buffer;
        private int count;

        public Board(final int screen, final int selected, final int buffer, final int count) {
            this.screen = screen;
            this.selected = selected;
            this.buffer = buffer;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            final Board board = (Board) o;
            return screen == board.screen && selected == board.selected && buffer == board.buffer;
        }

    }
}
