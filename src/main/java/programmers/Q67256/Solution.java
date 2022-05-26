package programmers.Q67256;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public String solution(final int[] numbers, final String hand) {
        final StringBuilder answer = new StringBuilder();
        final Map<Integer, Point> pad = initPad();
        final Point leftPoint = new Point(3, 0);
        final Point rightPoint = new Point(3, 2);

        for (final int number : numbers) {
            final Point destination = pad.get(number);
            final int lDistance = destination.getLength(leftPoint);
            final int rDistance = destination.getLength(rightPoint);
            if(List.of(1, 4, 7).contains(number)) {
                pressLeft(leftPoint, destination, answer);
                continue;
            }

            if(List.of(3, 6, 9).contains(number)) {
                pressRight(rightPoint, destination, answer);
                continue;
            }

            if(lDistance > rDistance) {
                pressRight(rightPoint, destination, answer);
                continue;
            }

            if(lDistance < rDistance) {
                pressLeft(leftPoint, destination, answer);
                continue;
            }

            if(hand.equals("left")) {
                pressLeft(leftPoint, destination, answer);
                continue;
            }

            if(hand.equals("right")) {
                pressRight(rightPoint, destination, answer);
                continue;
            }
        }
        return answer.toString();
    }

    private void pressLeft(final Point point, final Point destination, final StringBuilder sb) {
        point.setPoint(destination);
        sb.append("L");
    }

    private void pressRight(final Point point, final Point destination, final StringBuilder sb) {
        point.setPoint(destination);
        sb.append("R");
    }

    private Map<Integer, Point> initPad() {
        final Map<Integer, Point> pad = new HashMap<>();
        pad.put(1, new Point(0, 0));
        pad.put(2, new Point(0, 1));
        pad.put(3, new Point(0, 2));
        pad.put(4, new Point(1, 0));
        pad.put(5, new Point(1, 1));
        pad.put(6, new Point(1, 2));
        pad.put(7, new Point(2, 0));
        pad.put(8, new Point(2, 1));
        pad.put(9, new Point(2, 2));
        pad.put(0, new Point(3, 1));

        return pad;
    }

    private static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getLength(final Point point) {
            return Math.abs(this.x - point.x) + Math.abs(this.y - point.y);
        }

        public void setPoint(final Point point) {
            this.x = point.x;
            this.y = point.y;
        }

    }

    public static void main(String[] args) {
        final int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        final String hand = "left";
        System.out.println(new Solution().solution(numbers, hand).equals("LRLLRRLLLRR"));
    }

}