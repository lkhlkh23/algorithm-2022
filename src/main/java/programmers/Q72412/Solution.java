package programmers.Q72412;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(final String[] info, final String[] query) {
        final Map<String, int[]> infos = new HashMap<>();
        for (final String s : info) {
            addAllCaseInfo(s, infos);
        }

        final int[] answer = new int[query.length];
        for (int index = 0; index < answer.length; index++) {
            final String[] split = query[index].replaceAll(" and ", "").split(" ");
            final int[] infoScore = infos.get(split[0]);
            if(infoScore == null) {
                answer[index] = 0;
            }

            if(infoScore != null) {
                for (int i = Integer.parseInt(split[1]); i < infoScore.length; i++) {
                    answer[index] += infoScore[i];
                }
            }
        }

        return answer;
    }

    private void addAllCaseInfo(final String s, final Map<String, int[]> infos) {
        final String[] split = s.split(" ");
        for (String language : new String[]{split[0], "-"}) {
            for (String job : new String[]{split[1], "-"}) {
                for (String career : new String[]{split[2], "-"}) {
                    for (String food : new String[]{split[3], "-"}) {
                        final String info = language + job + career + food;
                        final int score = Integer.parseInt(split[4]);
                        if(infos.containsKey(info)) {
                            infos.get(info)[score]++;
                        } else {
                            final int[] arr = new int[100001];
                            arr[score]++;
                            infos.put(info, arr);
                        }
                    }
                }
            }
        }
    }

}