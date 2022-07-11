package baekjoon.Q2480;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String[] inputs = new Scanner(System.in).nextLine().split(" ");
        final Map<String, Integer> map = new HashMap<>();
        for (final String input : inputs) {
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        final String first = map.entrySet()
                                .stream()
                                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                .findFirst()
                                .get()
                                .getKey();

        if(map.size() == 1) {
            System.out.println(10000 + 1000 * Integer.parseInt(first));
        } else if(map.size() == 2) {
            System.out.println(1000 + 100 * Integer.parseInt(first));
        } else {
            System.out.println(100 * Math.max(Integer.parseInt(inputs[0]), Math.max(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]))));
        }
    }

}
