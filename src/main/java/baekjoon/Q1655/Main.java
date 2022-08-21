package baekjoon.Q1655;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
            if(i <= 1) {
                System.out.println(queue.peek());
            } else {
                final List<Integer> temp = new ArrayList<>();
                for (int j = 0; j <= i / 2; j++) {
                    temp.add(queue.poll());
                }
                System.out.println(temp.get(temp.size() - 1));
                queue.addAll(temp);
            }
        }
    }

}
