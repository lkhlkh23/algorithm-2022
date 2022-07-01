package baekjoon.Q2525;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] first = scanner.nextLine().split(" ");
        final int hour = Integer.parseInt(first[0]);
        final int minutes = Integer.parseInt(first[1]);
        final int time = Integer.parseInt(scanner.nextLine());

        final int sumOfHour = ((minutes + time) / 60) + hour;
        System.out.println((sumOfHour >= 24 ? (sumOfHour - 24) : sumOfHour) + " " + ((minutes + time) % 60));
    }

}
