package baekjoon.Q1463;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(bfs(Integer.parseInt(new Scanner(System.in).nextLine())));
    }

    private static int bfs(final int x) {
        final boolean[] visited = new boolean[x + 1];
        final Queue<No> queue = new LinkedList<>();
        queue.add(new No(x, 0));

        final Queue<No> temp = new LinkedList<>();
        while(!queue.isEmpty()) {
            final No poll = queue.poll();
            if(poll.no == 1) {
                return poll.cnt;
            }

            if(visited[poll.no]) {
                continue;
            }

            visited[poll.no] = true;

            if(poll.no % 3 == 0) {
                temp.add(new No(poll.no / 3, poll.cnt + 1));
            }

            if(poll.no % 2 == 0) {
                temp.add(new No(poll.no / 2, poll.cnt + 1));
            }

            temp.add(new No(poll.no - 1, poll.cnt + 1));

            while(queue.isEmpty()) {
                queue.addAll(temp);
                temp.clear();
            }
        }

        return 0;
    }

    private static class No {
        private int no;
        private int cnt;

        public No(final int no, final int cnt) {
            this.no = no;
            this.cnt = cnt;
        }
    }

}
