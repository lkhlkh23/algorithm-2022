package baekjoon.Q14226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // not completed

    public static void main(String[] args) {
        System.out.println(bfs(Integer.parseInt(new Scanner(System.in).nextLine())));
    }

    private static int bfs(final int s) {
        final Queue<Command> queue = new LinkedList<>();
        queue.add(new Command(1, 0, 0));

        while(!queue.isEmpty()) {
            final Command command = queue.poll();

            if(command.screen == s) {
                return command.cnt;
            }

            if(command.board < 0 || command.screen < 0 || command.board >= 10001 || command.screen >= 1001) {
                continue;
            }

            queue.add(new Command(command.screen, command.screen, command.cnt + 1));
            queue.add(new Command(command.screen + command.board, command.board, command.cnt + 1));
            queue.add(new Command(command.screen - 1, command.board, command.cnt + 1));
        }

        return 0;
    }

    private static class Command {
        private int screen;
        private int board;
        private int cnt;

        public Command(final int screen, final int board, final int cnt) {
            this.screen = screen;
            this.board = board;
            this.cnt = cnt;
        }
    }
}
