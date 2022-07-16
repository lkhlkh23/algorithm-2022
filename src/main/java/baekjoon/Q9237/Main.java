package baekjoon.Q9237;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final List<Integer> tress = Arrays.stream(scanner.nextLine().split(" "))
                                          .map(Integer::parseInt)
                                          .sorted(Collections.reverseOrder())
                                          .collect(Collectors.toList());
        int max = -1;
        for (int i = 0; i < tress.size(); i++) {
            max = Math.max(max, i + tress.get(i) + 2);
        }

        System.out.println(max);
    }
}
