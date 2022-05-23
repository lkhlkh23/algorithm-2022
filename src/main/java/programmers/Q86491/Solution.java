package programmers.Q86491;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {

    public int solution(final int[][] sizes) {
        return Stream.of(sizes).flatMapToInt(IntStream::of).max().orElse(0)
            * Arrays.stream(sizes).map(s -> Math.min(s[0], s[1])).max(Comparator.naturalOrder()).orElse(0);
    }

}