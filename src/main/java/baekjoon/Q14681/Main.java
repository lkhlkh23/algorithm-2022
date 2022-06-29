package baekjoon.Q14681;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int x = Integer.parseInt(scanner.nextLine());
        final int y = Integer.parseInt(scanner.nextLine());

        System.out.println(x > 0 && y > 0 ? 1 : (x < 0 && y > 0) ? 2 : (x < 0 && y < 0) ? 3 : 4);
    }
}
