package baekjoon.Q8958;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int hit = 1;
            int sum = 0;
            final String[] inputs = scanner.nextLine().split("");
            for (final String input : inputs) {
                if("O".equals(input)) {
                    sum += hit++;
                    continue;
                }
                hit = 1;
            }
            System.out.println(sum);
        }
    }

}
