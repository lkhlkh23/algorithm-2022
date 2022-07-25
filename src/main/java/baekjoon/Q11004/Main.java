package baekjoon.Q11004;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        final List<Integer> nos = Arrays.stream(scanner.nextLine().split(" "))
                                        .map(Integer::parseInt)
                                        .collect(Collectors.toList());

        final int[] arr = new int[1000000000 + 1];
        for (final int no : nos) {
            if(no < 0) {
                arr[no * -1]++;
            }
        }

        for (int i = arr.length - 1; i > 0; i--) {
            k -= arr[i];
            arr[i] = 0;
            if(k <= 0) {
                System.out.println(i);
                return;
            }
        }

        for (final int no : nos) {
            if(no > 0) {
                arr[no]++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            k -= arr[i];
            if(k <= 0) {
                System.out.println(i);
                return;
            }
        }
    }

}
