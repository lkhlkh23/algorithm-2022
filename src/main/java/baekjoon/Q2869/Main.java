package baekjoon.Q2869;

import java.util.Scanner;

public class Main {

    // not completed 시간초과

    public static void main(String[] args) {
        final String[] inputs = new Scanner(System.in).nextLine().split(" ");
        final int a = Integer.parseInt(inputs[0]);
        final int b = Integer.parseInt(inputs[1]);
        final int v = Integer.parseInt(inputs[2]);

        int start = (v / (a- b)) - 2;
        int current = start * (a - b);
        while(true) {
            current += a;
            start++;
            if(current >= v) {
                break;
            }
            current -= b;
        }

        System.out.println(start);
    }

}
