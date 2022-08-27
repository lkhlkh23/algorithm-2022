package baekjoon.Q3009;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Map<String, Integer> widths = new HashMap<>();
        final Map<String, Integer> heights = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            final String[] input = scanner.nextLine().split(" ");
            widths.put(input[0], widths.getOrDefault(input[0], 0) + 1);
            heights.put(input[1], heights.getOrDefault(input[1], 0) + 1);
        }

        for (final String width : widths.keySet()) {
            if(widths.get(width) == 1) {
                System.out.print(width + " ");
            }
        }

        for (final String height : heights.keySet()) {
            if(heights.get(height) == 1) {
                System.out.print(height);
            }
        }
    }
}
