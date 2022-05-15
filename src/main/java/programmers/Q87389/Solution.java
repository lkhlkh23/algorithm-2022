package programmers.Q87389;

class Solution {

    public static int solution(final int n) {
        for (int i = 2; i < n; i++) {
            if(n % i == 1) {
                return i;
            }
        }

        return 2;
    }

}