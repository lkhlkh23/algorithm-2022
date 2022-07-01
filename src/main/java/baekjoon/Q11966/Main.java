package baekjoon.Q11966;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(checkSquare(Integer.parseInt(new Scanner(System.in).nextLine())));
    }

    private static int checkSquare(final int n) {
        int i = 1;
        while(n >= Math.pow(2, i)) {
            if(n % Math.pow(2, i) != 0) {
                return 0;
            }

            i++;
        }

        return 1;
    }
}
