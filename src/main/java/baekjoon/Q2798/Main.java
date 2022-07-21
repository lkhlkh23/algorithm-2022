package baekjoon.Q2798;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static int max = -1;
    private static int result = -1;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        max = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        final List<Integer> cards = Arrays.stream(scanner.nextLine().split(" "))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
        combination(cards, new boolean[cards.size()], 0, 3);
        System.out.println(result);
    }

    private static void combination(final List<Integer> cards, final boolean[] visited, final int depth, final int limit) {
        if(limit == 0) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    sum += cards.get(i);
                }
            }

            if(sum <= max) {
                result = Math.max(result, sum);
            }
            return;
        }

        if(depth != cards.size()) {
            visited[depth] = true;
            combination(cards, visited, depth + 1, limit - 1);

            visited[depth] = false;
            combination(cards, visited, depth + 1, limit);
        }
    }


}
