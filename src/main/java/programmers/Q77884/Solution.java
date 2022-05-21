package programmers.Q77884;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int solution(final int left, final int right) {
        int answer = 0;
        final List<Integer> squares = IntStream.range(1, 1001).map(i -> i * i).boxed().collect(Collectors.toList());
        for (int i = left; i <= right; i++) {
            answer += (squares.contains(i) ? -1 * i : i);
        }

        return answer;
    }

}
