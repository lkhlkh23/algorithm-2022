package baekjoon.Q9095;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            System.out.println(memory(Integer.parseInt(scanner.nextLine())));
        }
    }

    private static int memory(final int n) {
        final int[] nums = new int[10000 + 1];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;
        for (int i = 4; i < nums.length; i++) {
            // nums[4] -> (3 num[1]) + (2 num[2]) + (1 num[3]) = 1 + 2 + 4 = 7
            // nums[5] -> (3 num[2]) + (2 num[3]) + (1 num[4]) = 2 + 4 + 7 = 13
            nums[i] = nums[i - 3] + nums[i - 2] + nums[i - 1];
        }

        return nums[n];
    }

}
