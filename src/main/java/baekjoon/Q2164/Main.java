package baekjoon.Q2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int n = new Scanner(System.in).nextInt();
        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() >= 2) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }

}
