package baekjoon.Q1655;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // not completed

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final Queue<Integer> first = new PriorityQueue<>();
        final Queue<Integer> second = new PriorityQueue<>();
        int maxInFirst = -1;
        for (int i = 0; i < n; i++) {
            if(i <= 1) {
                final int num = scanner.nextInt();
                first.add(scanner.nextInt());
                System.out.println(first.peek());
            } else {

            }
        }
    }

}
