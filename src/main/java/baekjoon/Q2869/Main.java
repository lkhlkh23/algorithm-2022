package baekjoon.Q2869;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String[] inputs = new Scanner(System.in).nextLine().split(" ");
        final int a = Integer.parseInt(inputs[0]);
        final int b = Integer.parseInt(inputs[1]);
        final int v = Integer.parseInt(inputs[2]);

        int current = 0;
        int day = 0;
        while(true) {
            current += a;
            day++;
            if(current >= v) {
                break;
            }
            current -= b;
        }
        System.out.println(day);
    }

}
