package baekjoon.Q2294;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] firstLine = scanner.nextLine().split(" ");
        final List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(firstLine[0]); i++) {
            coins.add(Integer.parseInt(scanner.nextLine()));
        }

        final int[] nums = init(Integer.parseInt(firstLine[1]), coins);
        // 100001, 1, 2, 3, 4, 1, 6, 7, 8, 9, 2, 11, 1, 13, 14, 3,
        for (int i = 1; i < nums.length; i++) {

        }

    }

    private static int[] init(final int size, final List<Integer> coins) {
        final int[] nums = new int[size + 1];
        Arrays.fill(nums, 100001);

        for (final Integer coin : coins) {
            for (int i = 1; i <= ((nums.length - 1) / coin); i++) {
                nums[coin * i] = Math.min(nums[coin * i], i);
            }
        }

        return nums;
    }
}
