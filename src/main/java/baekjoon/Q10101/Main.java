package baekjoon.Q10101;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int a = Integer.parseInt(scanner.nextLine());
        final int b = Integer.parseInt(scanner.nextLine());
        final int c = Integer.parseInt(scanner.nextLine());
        if(a + b + c != 180) {
            System.out.println("Error");
            return;
        }

        final Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);

        if(set.size() == 1) {
            System.out.println("Equilateral");
        } else if(set.size() == 2) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }

}
