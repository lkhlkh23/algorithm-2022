package programmers.Q86051;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public int solution(final int[] numbers) {
        final int[] arr = IntStream.range(0, 10).toArray();
        for (final int number : numbers) {
            arr[number] = 0;
        }
        return Arrays.stream(arr).sum();
    }

}