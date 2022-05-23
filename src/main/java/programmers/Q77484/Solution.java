package programmers.Q77484;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int[] solution(final int[] lottos, final int[] win_nums) {
        final List<Integer> winnerNos = Arrays.stream(win_nums)
                                              .boxed()
                                              .collect(Collectors.toList());
        final int matched = (int) Arrays.stream(lottos).filter(winnerNos::contains).count();
        final int last = Math.min(6 - matched + 1, 6);
        final int countOfZero = (int) Arrays.stream(lottos).filter(l -> l == 0).count();
        final int first = Math.min(6 - (matched + countOfZero) + 1, 6);

        return new int[]{first, last};
    }

}
