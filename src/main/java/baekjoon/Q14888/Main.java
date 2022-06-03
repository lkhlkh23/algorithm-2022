package baekjoon.Q14888;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final int[] num = Arrays.stream(scanner.nextLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        final String[] ops = scanner.nextLine().split(" ");
        final String operands = "++++++++++++".substring(0, Integer.parseInt(ops[0])) +
                                "------------".substring(0, Integer.parseInt(ops[1])) +
                                "************".substring(0, Integer.parseInt(ops[2])) +
                                "////////////".substring(0, Integer.parseInt(ops[3]));
        final Set<String> results = new HashSet<>();
        permutation(operands, "", operands.length(), results);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (final String result : results) {
            int cal = num[0];
            for (int i = 1; i < num.length; i++) {
                switch (result.split("")[i - 1]) {
                    case "+" : cal += num[i]; break;
                    case "-" : cal -= num[i]; break;
                    case "*" : cal *= num[i]; break;
                    case "/" : cal /= num[i]; break;
                }
            }
            min = Math.min(min, cal);
            max = Math.max(max, cal);
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void permutation(final String operand, final String completed, final int max, final Set<String> results) {
        if(completed.length() == max) {
            results.add(completed);
        }

        for (int i = 0; i < operand.length(); i++) {
            final StringBuilder sb = new StringBuilder();
            for (int j = 0; j < operand.length(); j++) {
                if(i != j) {
                    sb.append(operand.charAt(j));
                }
            }

            permutation(sb.toString(), (String.copyValueOf(completed.toCharArray()) + operand.charAt(i)), max, results);
        }
    }

}
