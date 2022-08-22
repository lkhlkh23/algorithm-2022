package baekjoon.Q12865;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // not completed

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] first = scanner.nextLine().split(" ");
        final int n = Integer.parseInt(first[0]);
        final int k = Integer.parseInt(first[1]);

        final List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final String[] inputs = scanner.nextLine().split(" ");
            items.add(new Item(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }
    }

    private static void dfs(final List<Item> items, final int k) {
        
    }

    private static class Item {
        private int weight;
        private int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}
