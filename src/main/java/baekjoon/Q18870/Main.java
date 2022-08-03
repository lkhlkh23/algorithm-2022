package baekjoon.Q18870;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final String[] inputs = scanner.nextLine().split(" ");
        final List<Integer> nos = Arrays.stream(inputs)
                                        .map(Integer::parseInt)
                                        .distinct()
                                        .sorted()
                                        .collect(Collectors.toList());
        final Map<Integer, Integer> results = new HashMap<>();
        for (int i = 0; i < nos.size(); i++) {
            results.put(nos.get(i), i);
        }

        final StringBuilder sb = new StringBuilder();
        for (final String input : inputs) {
            sb.append(results.get(Integer.parseInt(input))).append(" ");
        }

        System.out.println(sb.toString());
    }
}
