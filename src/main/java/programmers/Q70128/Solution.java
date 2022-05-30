package programmers.Q70128;

class Solution {

    public int solution(final int[] a, final int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += (a[i] * b[i]);
        }

        return sum;
    }

}