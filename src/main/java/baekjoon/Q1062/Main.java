package baekjoon.Q1062;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] first = scanner.nextLine().split(" ");

        final List<String> must = List.of("a", "n", "t", "i", "c");
        final int rest = Integer.parseInt(first[1]) - must.size();
        if(rest < 0) {
            System.out.println("0");
            return;
        }

        final List<String> subset = new ArrayList<>();
        final List<String> words = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(first[0]); i++) {
            final String word = scanner.nextLine();
            for (String s : word.substring(4, word.length() - 4).split("")) {
                if(!must.contains(s) && !subset.contains(s)) {
                    subset.add(s);
                }
            }
            words.add(word);
        }

        final List<String> result = new ArrayList<>();
        combination(subset, new boolean[subset.size()], 0, rest, result);
        int max = 0;
        for (final String s : result) {
            final List<String> letters = new ArrayList<>(List.of(s.split("")));
            letters.addAll(must);
            int hit = 0;
            for (final String word : words) {
                hit = Arrays.stream(word.split("")).allMatch(letters::contains) ? hit + 1 : hit;
            }
            max = Math.max(max, hit);
        }
        System.out.println(max);
    }

    private static void combination(final List<String> materials, final boolean[] visited, final int start, final int r, final List<String> result) {
        if(r == 0) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < materials.size(); i++) {
                if(visited[i]) {
                    sb.append(materials.get(i));
                }
            }
            result.add(sb.toString());
            return;
        }

        for(int i = start; i < materials.size(); i++) {
            visited[i] = true;
            combination(materials, visited, i + 1, r - 1, result);
            visited[i] = false;
        }
    }

}
