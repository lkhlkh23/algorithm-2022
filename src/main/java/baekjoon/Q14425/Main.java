package baekjoon.Q14425;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] inputs = scanner.nextLine().split(" ");
        final Set<String> set = new HashSet<>();
        for (int i = 0; i < Integer.parseInt(inputs[0]); i++) {
            set.add(scanner.nextLine());
        }

        int hit = 0;
        for (int i = 0; i < Integer.parseInt(inputs[1]); i++) {
            hit = set.contains(scanner.nextLine()) ? hit + 1 : hit;
        }

        System.out.println(hit);
    }

}
