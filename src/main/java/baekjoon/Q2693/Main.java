package baekjoon.Q2693;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            final int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                                    .mapToInt(Integer::parseInt)
                                    .boxed()
                                    .sorted(Comparator.reverseOrder())
                                    .mapToInt(x -> Integer.parseInt(String.valueOf(x)))
                                    .toArray();

            System.out.println(arr[2]);
        }
    }

}
