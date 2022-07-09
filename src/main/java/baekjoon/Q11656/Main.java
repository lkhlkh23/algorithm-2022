package baekjoon.Q11656;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String s = new Scanner(System.in).nextLine();
        final List<String> suffixes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            suffixes.add(s.substring(i));
        }

        suffixes.stream().sorted().forEach(System.out::println);
    }

}
