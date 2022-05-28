package programmers.Q76501;

class Solution {

    public int solution(final int[] absolutes, final boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            sum += (absolutes[i] * (signs[i] ? 1 : -1));
        }

        return sum;
    }

}