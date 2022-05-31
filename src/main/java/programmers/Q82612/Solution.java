package programmers.Q82612;

class Solution {

    public long solution(final int price, final int money, final int count) {
        return Math.max((((long) count * (count + 1) * price) / 2) - money, 0);
    }

}