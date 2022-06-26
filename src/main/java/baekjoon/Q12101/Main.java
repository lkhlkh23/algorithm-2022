package baekjoon.Q12101;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] inputs= scanner.nextLine().split(" ");
        final int n = Integer.parseInt(inputs[0]);
        final int k = Integer.parseInt(inputs[1]);

        final Plus[] pluses = new Plus[11];
        pluses[1] = new Plus(1, List.of("1"));
        pluses[2] = new Plus(2, List.of("1+1", "2"));
        pluses[3] = new Plus(3, List.of("1+1+1", "1+2", "2+1", "3"));

        // nos[4] = (1 nos[3]) + (2 nos[2]) + (3 nos[1])
        for (int i = 4; i < pluses.length; i++) {
            final List<String> all = new ArrayList<>();
            for (int j = 1; j < 4; j++) {
                final List<String> nos = pluses[i - j].expressions;
                for (final String no : nos) {
                    all.add(j + "+" + no);
                }
            }
            pluses[i] = new Plus(i, all);
        }

        System.out.println(pluses[n].getExpression(k - 1));
    }

    private static class Plus {
        private int no;
        private List<String> expressions;

        public Plus(int no, List<String> expressions) {
            this.no = no;
            this.expressions = expressions;
        }

        public String getExpression(final int index) {
            return expressions.size() <= index ? "-1" : expressions.get(index);
        }
    }
}
