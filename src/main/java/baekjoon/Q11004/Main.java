package baekjoon.Q11004;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int k = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        final String[] inputs = scanner.nextLine().split(" ");
        final int[] arr = new int[1000000000 + 1];
        for (final String input : inputs) {
            final int no = Integer.parseInt(input);
            arr[no]++;
        }

        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if(sum >= k) {
                System.out.println(i);
                break;
            }
        }
    }


}
