package baekjoon.Q25305;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] first = scanner.nextLine().split(" ");
        final List<Integer> second = Arrays.stream(scanner.nextLine().split(" "))
                                           .map(Integer::parseInt)
                                           .sorted(Comparator.reverseOrder())
                                           .collect(Collectors.toList());
        System.out.println(second.get(Integer.parseInt(first[1]) - 1));
    }

}
