package baekjoon.Q8911;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            final Stack<Turtle> turtles = new Stack<>();
            turtles.add(new Turtle(0, 0, 0));
            for (final char command : scanner.nextLine().toCharArray()) {
                turtles.add(turtles.peek().copyFrom().applyCommand(command));
            }

            int px = 0;
            int py = 0;
            int mx = 0;
            int my = 0;
            while(!turtles.isEmpty()) {
                final Turtle turtle = turtles.pop();
                px = Math.max(px, turtle.x);
                py = Math.max(py, turtle.y);
                mx = Math.min(mx, turtle.x);
                my = Math.min(my, turtle.y);
            }

            System.out.println((px + Math.abs(mx)) * (py + Math.abs(my)));
        }
    }

    private static class Turtle {

        private int x;
        private int y;
        private int direction; // 0 : N, 1 : E, 2 : S, 3 : W

        public Turtle(final int currentX, final int currentY, final int direction) {
            this.x = currentX;
            this.y = currentY;
            this.direction = direction;
        }

        public Turtle copyFrom(){
            return new Turtle(this.x, this.y, this.direction);
        }

        public Turtle applyCommand(final char command) {
            if(List.of('F', 'B').contains(command)) {
                return move(command == 'F');
            }

            return rotate(command == 'L');
        }

        private Turtle move(boolean isForward) {
            switch (direction) {
                case 0 :
                    this.y = this.y + (isForward ? 1 : -1);
                    return this;
                case 1 :
                    this.x = this.x + (isForward ? 1 : -1);
                    return this;
                case 2 :
                    this.y = this.y + (isForward ? -1 : 1);
                    return this;
                default:
                    this.x = this.x + (isForward ? -1 : 1);
                    return this;
            }
        }

        private Turtle rotate(final boolean isLeft) {
            this.direction = this.direction + (isLeft ? -1 : 1);
            this.direction = this.direction == -1 ? 3 : this.direction == 4 ? 0 : this.direction;

            return this;
        }

    }

}
