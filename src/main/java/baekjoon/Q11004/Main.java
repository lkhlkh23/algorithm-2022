package baekjoon.Q11004;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int k = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        final int[] inputs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(inputs);

        System.out.println(inputs[k - 1]);
    }

}
