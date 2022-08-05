package baekjoon.Q1436;

import java.util.Scanner;

public class Main {

    // completed (금)

    public static void main(String[] args) {
        final int n = Integer.parseInt(new Scanner(System.in).nextLine());
        int cnt = 1;
        int no = 666;
        while(cnt != n) {
            no++;
            if(String.valueOf(no).contains("666")) {
                cnt++;
            }
        }

        System.out.println(no);
    }
}
