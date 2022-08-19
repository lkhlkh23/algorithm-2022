package baekjoon.Q2884;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int total = (scanner.nextInt() * 60 + scanner.nextInt()) + (24 * 60) - 45;
        total = total >= 24 * 60 ? total - (24 * 60) : total;
        System.out.println(total / 60 + " " + total % 60);
    }

}
