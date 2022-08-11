package baekjoon.Q4153;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!"0 0 0".equals(input = scanner.nextLine())) {
            final List<Integer> nos = Arrays.stream(input.split(" "))
                                            .map(Integer::parseInt)
                                            .sorted()
                                            .collect(Collectors.toList());
            System.out.println((nos.get(0) * nos.get(0) + nos.get(1) * nos.get(1)) == (nos.get(2) * nos.get(2)) ? "right" : "wrong");
        }
    }
}
