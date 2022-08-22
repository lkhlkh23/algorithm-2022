package baekjoon.Q1062;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // not completed

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] first = scanner.nextLine().split(" ");

        final List<String> must = List.of("a", "n", "t", "i", "c");
        final int rest = Integer.parseInt(first[1]) - must.size();
        if(rest < 0) {
            System.out.println("0");
            return;
        }

        final List<String> restWords = new ArrayList<>();
        final List<String> words = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(first[0]); i++) {
            final String word = scanner.nextLine()
                                       .replaceAll("a", "")
                                       .replaceAll("n", "")
                                       .replaceAll("t", "")
                                       .replaceAll("i", "")
                                       .replaceAll("c", "");
            for (final String letter : word.split("")) {
                if(!restWords.contains(letter)) {
                    restWords.add(letter);
                }
            }

            words.add(word);
        }

        final List<String> subsets = new ArrayList<>();
        combination(restWords, new boolean[restWords.size()], 0, rest, subsets);
        int max = 0;
        for (final String subset : subsets) {
            int hit = 0;
            for (final String word : words) {
                // hit = subset.matches("(.*)" + wo)
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
