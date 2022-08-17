package baekjoon.Q18258;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // not completed (시간초과)

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final Queue<Integer> queue = new LinkedList<>();
        final Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            final String input = scanner.nextLine();
            if(input.startsWith("push")) {
                queue.add(Integer.parseInt(input.split(" ")[1]));
            }

            if(input.startsWith("pop")) {
                System.out.println(queue.isEmpty() ? -1 : queue.poll());
            }

            if(input.startsWith("size")) {
                System.out.println(queue.size());
            }

            if(input.startsWith("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            }

            if(input.startsWith("front")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peek());
            }

            if(input.startsWith("back")) {
                int poll = -1;
                while(!queue.isEmpty()) {
                    poll = queue.poll();
                    temp.add(poll);
                }
                queue.addAll(temp);
                temp.clear();

                System.out.println(poll);
            }
        }
    }
}
