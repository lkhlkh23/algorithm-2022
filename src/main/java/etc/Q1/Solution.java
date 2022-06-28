package etc.Q1;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static int solution(final String s) {
        int result = 0;
        final Queue<Character> queue = new LinkedList<>();
        for (final char c : s.toCharArray()) {
            queue.add(c);
        }

        char c = queue.poll();
        while(!queue.isEmpty()) {
            final char poll = queue.poll();
            if((c == 'a' && poll == 'z') || (c == 'z' && poll == 'a')) {
                result++;
                c = poll;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcz")); // 1
        System.out.println(solution("xxx")); // 0
        System.out.println(solution("zabzczxa")); // 3
    }
}
