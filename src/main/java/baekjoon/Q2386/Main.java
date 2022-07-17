package baekjoon.Q2386;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!"#".equals(input = scanner.nextLine())) {
            final char character = input.charAt(0);
            int cnt = 0;
            for (final char c : input.substring(2).toLowerCase(Locale.ROOT).toCharArray()) {
                if(c == character) {
                    cnt++;
                }
            }
            System.out.println(character + " " + cnt);
        }
    }

}
