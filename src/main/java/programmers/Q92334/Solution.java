package programmers.Q92334;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int[] solution(final String[] id_list, final String[] report, int k) {
        final Map<String, Set<String>> accusedPeople = new HashMap<>(); // <신고자, 신고당한 사람 목록>
        for (final String s : report) {
            final String[] split = s.split(" ");
            if(accusedPeople.containsKey(split[0])) {
                accusedPeople.get(split[0]).add(split[1]);
            } else {
                final Set<String> accused = new HashSet<>();
                accused.add(split[1]);
                accusedPeople.put(split[0], accused);
            }
        }

        final Map<String, Integer> accusedCount = new HashMap<>(); // <신고당한 사람, 횟수>
        for (final String id : id_list) {
            // 신고당한 사람의 횟수를 0 으로 초기화
            accusedCount.put(id, 0);
        }

        for (final Set<String> accusedList : accusedPeople.values()) {
            for (final String s : accusedList) {
                // 신고당한 사람의 횟수를 설정 (Set 이라서 중복없음)
                accusedCount.put(s, accusedCount.get(s) + 1);
            }
        }

        final int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            for (final String accused : accusedPeople.getOrDefault(id_list[i], new HashSet<>())) {
                if(accusedCount.get(accused) >= k) {
                    // k번 이상 신고당해서 통보 메일의 횟수를 추가
                    answer[i]++;
                }
            }
        }

        return answer;
    }

}
