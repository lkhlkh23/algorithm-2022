package baekjoon.Q18258;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final StringBuilder sb = new StringBuilder();
        final int[] queue = new int[n + 1];
        int start = 0;
        int end = 0;
        int size = 0;
        for (int i = 0; i < n; i++) {
            final String input = scanner.nextLine();
            if("pop".equals(input)) {
                if(size == 0) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue[start++]).append("\n");
                    size--;
                }
            } else if("size".equals(input)) {
                sb.append(size).append("\n");
            } else if("empty".equals(input)) {
                sb.append(size == 0 ? 1 : 0).append("\n");
            } else if("front".equals(input)) {
                sb.append(size == 0 ? -1 : queue[start]).append("\n");
            } else if("back".equals(input)) {
                sb.append(size == 0 ? -1 : queue[end - 1]).append("\n");
            } else {
                queue[end++] = Integer.parseInt(input.split(" ")[1]);
                size++;
            }
        }

        System.out.println(sb.toString());
    }

}

