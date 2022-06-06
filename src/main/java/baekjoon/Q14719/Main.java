package baekjoon.Q14719;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] heightAndWidth = scanner.nextLine().split(" ");
        final String[] blocks = scanner.nextLine().split(" ");

        int water = 0;
        for (int i = 1; i < blocks.length - 1; i++) {
            int left = 0;
            int right = 0;

            // 1. 현재 블럭기준으로 왼쪽에서 제일 긴 블록 찾기
            for (int j = 0; j < i; j++) {
                left = Math.max(Integer.parseInt(blocks[j]), left);
            }

            // 2. 현재 블럭기준으로 오른쪽에서 제일 긴 블록 찾기
            for (int j = i + 1; j < blocks.length; j++) {
                right = Math.max(Integer.parseInt(blocks[j]), right);
            }

            // 3. 현재 블록이 (왼쪽 과 오른쪾) 블록보다 작다면, 물이 고임
            if(Math.min(left, right) > Integer.parseInt(blocks[i])) {
                water += (Math.min(left, right) - Integer.parseInt(blocks[i]));
            }
        }

        System.out.println(water);
    }

}
