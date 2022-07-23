package baekjoon.Q2588;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int a = Integer.parseInt(scanner.nextLine());
        final String b = scanner.nextLine();

        for (int i = b.length() - 1; i >= 0; i--) {
            System.out.println(a * ((int) b.charAt(i) - 48));
        }

        System.out.println(a * Integer.parseInt(b));
    }

}
