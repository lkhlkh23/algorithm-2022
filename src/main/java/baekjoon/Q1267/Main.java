package baekjoon.Q1267;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final List<Integer> times = Arrays.stream(scanner.nextLine().split(" "))
                                          .map(Integer::parseInt)
                                          .collect(Collectors.toList());
        int m = 0;
        int y = 0;
        for (final Integer time : times) {
            if(time % 30 == 0) {
                y += (((time / 30) + 1) * 10);
            } else {
                y += (Math.ceil((double) time / 30) * 10);
            }

            if(time % 60 == 0) {
                m += (((time / 60) + 1) * 15);
            } else {
                m += (Math.ceil((double) time / 60) * 15);
            }
        }

        System.out.println(m > y ? "Y " + y : m < y ? "M " + m : "Y M " + m);
    }

}
