package baekjoon.Q2851;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<Integer> nos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            nos.add(Integer.parseInt(scanner.nextLine()));
        }

        final int[] sum = new int[nos.size()];
        sum[0] = nos.get(0);
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nos.get(i);
        }

        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            if(min >= Math.abs(sum[i] - 100)) {
                index = i;
                min = Math.abs(sum[i] - 100);
            }
        }

        System.out.println(sum[index]);
    }

}
