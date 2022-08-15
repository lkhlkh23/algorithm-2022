package baekjoon.Q17298;

import java.util.Scanner;

public class Main {

    // not completed (시간초과)

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final String[] inputs = scanner.nextLine().split(" ");
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputs.length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < inputs.length; j++) {
                if(Integer.parseInt(inputs[i]) >= Integer.parseInt(inputs[j])) {
                    continue;
                }

                sb.append(inputs[j]).append(" ");
                flag = true;
                break;
            }

            if(!flag) {
                sb.append("-1 ");
            }
        }

        sb.append("-1");

        System.out.println(sb.toString());
    }
}
