package baekjoon.Q5557;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final List<Integer> nos = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());
        System.out.println(dfs(nos));
    }

    private static int dfs(final List<Integer> nos) {
        final Stack<No> stack = new Stack<>();
        stack.add(new No(nos.get(0), 0));

        int cnt = 0;
        while(!stack.isEmpty()) {
            final No no = stack.pop();
            if(no.sum < 0 || no.sum > 20) {
                continue;
            }

            if(no.index == nos.size() -2) {
                if(no.sum == nos.get(nos.size() - 1)) {
                    cnt++;
                }
                continue;
            }

            stack.add(new No(no.sum + nos.get(no.index + 1), no.index + 1));
            stack.add(new No(no.sum - nos.get(no.index + 1), no.index + 1));
        }

        return cnt;
    }

    private static class No {
        private int sum;
        private int index;

        public No(final int sum, final int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}
