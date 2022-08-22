package etc.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    // not completed

    public static String solution(final String t) {
        final List<Integer> temperature = Arrays.stream(t.split(" "))
                                                .map(Integer::parseInt)
                                                .collect(Collectors.toList());
        final List<Integer> valid = new ArrayList<>();
        
        for (int i = 0; i < temperature.size(); i++) {

        }
        return "ERROR";
    }

    public static void main(String[] args) {

    }
}
