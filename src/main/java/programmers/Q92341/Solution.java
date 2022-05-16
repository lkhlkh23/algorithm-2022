package programmers.Q92341;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public int[] solution(final int[] fees, final String[] records) {
        final Map<String, Integer> timeOfCars = new HashMap<>();
        final Map<String, Integer> amountOfCars = new HashMap<>();
        applyBothInAndOut(records, timeOfCars, amountOfCars);
        applyOnlyInWithoutOut(timeOfCars, amountOfCars);

        return getCalculatedFees(amountOfCars, fees);
    }

    private void applyBothInAndOut(final String[] records, final Map<String, Integer> timeOfCars, final Map<String, Integer> amountOfCars) {
        for (final String record : records) {
            final String[] split = record.split(" ");
            final int time = Integer.parseInt(split[0].split(":")[0]) * 60 + Integer.parseInt(split[0].split(":")[1]);
            if("IN".equals(split[2])) {
                timeOfCars.put(split[1], time);
            }

            if("OUT".equals(split[2])) {
                final int inTime = timeOfCars.remove(split[1]);
                final int amount = time - inTime;
                amountOfCars.put(split[1], amountOfCars.getOrDefault(split[1], 0) + amount);
            }
        }
    }

    private void applyOnlyInWithoutOut(final Map<String, Integer> timeOfCars, final Map<String, Integer> amountOfCars) {
        for (final String carNum : timeOfCars.keySet()) {
            final int amount = ((60 * 24) -1) - timeOfCars.get(carNum);
            amountOfCars.put(carNum, amountOfCars.getOrDefault(carNum, 0) + amount);
        }
    }

    private int[] getCalculatedFees(final Map<String, Integer> amountOfCars, final int[] fees) {
        final int[] answer = new int[amountOfCars.size()];
        final List<String> sortedCars = amountOfCars.keySet()
                                                    .stream()
                                                    .sorted()
                                                    .collect(Collectors.toList());
        for (int i = 0; i < sortedCars.size(); i++) {
            final int amountOfTime = Math.max((amountOfCars.get(sortedCars.get(i))) - fees[0], 0);
            answer[i] = fees[1] + (int)((Math.ceil((double) amountOfTime / fees[2]) * fees[3]));
        }

        return answer;
    }

}
