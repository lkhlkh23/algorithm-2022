package programmers.Q68935;

class Solution {

    public int solution(final int n) {
        return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3);
    }

}