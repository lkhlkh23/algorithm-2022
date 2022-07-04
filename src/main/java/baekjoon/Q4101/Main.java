package baekjoon.Q4101;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!(input = scanner.nextLine()).equals("0 0")) {
            System.out.println(Integer.parseInt(input.split(" ")[0]) > Integer.parseInt(input.split(" ")[1]) ? "Yes" : "No");
        }
    }
}
