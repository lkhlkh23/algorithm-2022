package baekjoon.Q5086;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!"0 0".equals(input = scanner.nextLine())) {
            final int a = Integer.parseInt(input.split(" ")[0]);
            final int b = Integer.parseInt(input.split(" ")[1]);
            System.out.println(a <= b && b % a == 0 ? "factor" : a > b && a % b == 0 ? "multiple": "neither");
        }
    }
}
