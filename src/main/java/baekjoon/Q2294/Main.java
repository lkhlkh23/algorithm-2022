package baekjoon.Q2294;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] firstLine = scanner.nextLine().split(" ");
        final int n = Integer.parseInt(firstLine[0]);
        final int k = Integer.parseInt(firstLine[1]);
        final List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(scanner.nextLine()));
        }

        System.out.println(bfs(k, coins));
    }

    private static int bfs(final int k, final List<Integer> coins) {
        final Queue<Integer> queue = new LinkedList<>();
        final Queue<Integer> temps = new LinkedList<>();
        final boolean[] visited = new boolean[k + 1];
        for (final int coin : coins) {
            if(coin <= k) {
                queue.add(coin);
                visited[coin] = true;
            }
        }

        int cnt = 1;
        while (!queue.isEmpty()) {
            final int poll = queue.poll();
            for (final int coin : coins) {
                temps.offer(poll + coin);
            }

            if(queue.isEmpty()) {
                while(!temps.isEmpty()) {
                    final int temp = temps.poll();
                    if(temp == k) {
                        return cnt + 1;
                    }
                    if(temp > k || visited[temp]) {
                        continue;
                    }
                    visited[temp] = true;
                    queue.offer(temp);
                }
                cnt++;
            }
        }

        return -1;
    }

}
