package baekjoon.Q3568;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] commands = scanner.nextLine()
                                         .replaceAll(",", "")
                                         .replaceAll(";", "")
                                         .split(" ");
        for (int i = 1; i < commands.length; i++) {
            final StringBuilder variable = new StringBuilder();
            final StringBuilder type = new StringBuilder();
            for (char command : commands[i].toCharArray()) {
                if((command >= 'a' && command <= 'z') || (command >= 'A' && command <= 'Z')) {
                    variable.append(command);
                } else {
                    type.append(command);
                }
            }
            System.out.println(String.format("%s%s %s;", commands[0], type.reverse().toString().replaceAll("]\\[", "[]"), variable));
        }

    }
}
