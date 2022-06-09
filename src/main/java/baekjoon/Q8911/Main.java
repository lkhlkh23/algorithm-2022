package baekjoon.Q8911;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            final char[] commands = scanner.nextLine().toCharArray();
            final Turtle turtle = new Turtle();
            for (final char command : commands) {
                turtle.inputCommand(command);
            }
            System.out.println(turtle.calculate());
        }
    }

    private static class Turtle {

        private int currentX;
        private int currentY;
        private int direction; // 0 : N, 1 : E, 2 : S, 3 : W
        private int minusX;
        private int plusX;
        private int minusY;
        private int plusY;

        public void inputCommand(final char command) {
            switch (command) {
                case 'F' :
                    forward();
                    break;
                case 'B' :
                    back();
                    break;
                case 'L' :
                    left();
                    break;
                case 'R' :
                    right();
                    break;
            }
        }

        public void forward() {
            switch (direction) {
                case 0 :
                    this.currentY += 1;
                    this.plusY = Math.max(this.plusY, this.currentY);
                    break;
                case 1 :
                    this.currentX += 1;
                    this.plusX = Math.max(this.plusX, this.currentX);
                    break;
                case 2 :
                    this.currentY -= 1;
                    this.minusY = Math.min(this.minusY, this.currentY);
                    break;
                case 3 :
                    this.currentX -= 1;
                    this.minusX = Math.min(this.minusX, this.currentX);
                    break;
            }
        }

        public void back() {
            switch (direction) {
                case 0 :
                    this.currentY -= 1;
                    this.minusY = Math.min(this.minusY, currentY);
                    break;
                case 1 :
                    this.currentX -= 1;
                    this.minusX = Math.min(this.minusX, this.currentX);
                    break;
                case 2 :
                    this.currentY += 1;
                    this.plusY = Math.max(this.plusY, this.currentY);
                    break;
                case 3 :
                    this.currentX += 1;
                    this.plusX = Math.max(this.plusX, this.currentX);
                    break;
            }
        }

        public void left() {
            if(direction == 0) {
                this.direction = 3;
            } else {
                this.direction -= 1;
            }
        }

        public void right() {
            if(direction == 3) {
                this.direction = 0;
            } else {
                this.direction += 1;
            }
        }

        public int calculate() {
            return (Math.abs(this.minusX) + this.plusX) * (Math.abs((this.minusY) + this.plusY));
        }

    }

}
