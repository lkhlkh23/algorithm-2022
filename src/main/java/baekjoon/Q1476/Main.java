package baekjoon.Q1476;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String[] inputs = new Scanner(System.in).nextLine().split(" ");
        System.out.println(getCalendar(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])));
    }

    private static int getCalendar(final int e, final int s, final int m) {
        final int max = 1000;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if(15 * i + e == 28 * j + s) {
                    for (int k = 0; k < max; k++) {
                        if(28 * j + s == 19 * k + m) {
                            return 19 * k + m;
                        }
                    }
                }
            }
        }

        return 1;
    }
}
