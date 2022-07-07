package baekjoon.Q1269;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] first = scanner.nextLine().split(" ");
        final Set<String> second = Arrays.stream(scanner.nextLine().split(" "))
                                         .collect(Collectors.toSet());
        final long common = Arrays.stream(scanner.nextLine().split(" "))
                                  .filter(second::contains)
                                  .count();

        System.out.println(Integer.parseInt(first[0]) + Integer.parseInt(first[1]) - (2 * common));
    }

}
