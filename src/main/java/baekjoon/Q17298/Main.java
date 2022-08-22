package baekjoon.Q17298;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    // not completed (시간초과)
    // https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-17298-%EC%98%A4%ED%81%B0%EC%88%98-Java

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final String[] inputs = scanner.nextLine().split(" ");
        final Queue<Integer> queue = new LinkedList<>();
        final int[] temp = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            queue.add(Integer.parseInt(inputs[i]));
            temp[i] = Integer.parseInt(inputs[i]);
        }

        final int[] results = new int[inputs.length];
        for (int i = 0; i < results.length; i++) {
            final int target = temp[i];
            if(i > 0 && target < results[i - 1]) {
                results[i] = results[i - 1];
                continue;
            }
            int poll = -1;
            while(!queue.isEmpty()) {
                poll = queue.poll();
                if(poll > target) {
                    break;
                }
            }
            results[i] = poll;
        }

        for (int result : results) {
            System.out.print(result + " ");
        }
    }

    private static class No {
        private int num;
        private int index;

        public No(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

}
