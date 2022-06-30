package baekjoon.Q12026;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final char[] inputs = scanner.nextLine().toCharArray();

        final List<Step> steps = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            steps.add(new Step(inputs[i], i, inputs[i] == 'O' ? pow(i) : Integer.MAX_VALUE));
        }

        for (int i = 1; i < steps.size() - 1; i++) {
            final Step prev = steps.get(i);
            if(prev.value == Integer.MAX_VALUE) {
                continue;
            }

            for (int j = i + 1; j < steps.size(); j++) {
                final Step current = steps.get(j);
                if(!((prev.getLetter() == 'B' && current.getLetter() == 'O') ||
                    (prev.getLetter() == 'O' && current.getLetter() == 'J') ||
                    (prev.getLetter() == 'J' && current.getLetter() == 'B'))) {
                    continue;
                }
                current.setValue(Math.min(current.getValue(), pow(current.getIndex() - prev.getIndex()) + prev.getValue()));
            }

        }

        System.out.println(steps.get(n - 1).getValue() == Integer.MAX_VALUE ? -1 : steps.get(n - 1).getValue());
    }

    private static int pow(int num) {
        return num * num;
    }

    private static class Step {
        private char letter;
        private int index;
        private int value;

        public Step(final char letter, final int index, final  int value) {
            this.letter = letter;
            this.index = index;
            this.value = value;
        }

        public char getLetter() {
            return letter;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}