package baekjoon.Q3460;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
            final StringBuilder sb = new StringBuilder();
            final char[] binaryChars = Integer.toBinaryString(Integer.parseInt(sc.nextLine())).toCharArray();
            for (int j = 0; j < binaryChars.length; j++) {
                if(binaryChars[(binaryChars.length - j) - 1] == 49) {
                    sb.append(j + " ");
                }
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
