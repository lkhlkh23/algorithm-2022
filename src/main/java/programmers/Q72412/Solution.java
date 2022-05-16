package programmers.Q72412;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(final String[] info, final String[] query) {
        final List<Info> infos = Arrays.stream(info)
                                       .map(this::createInfo)
                                       .collect(Collectors.toList());
        final List<Info> queries = Arrays.stream(query)
                                         .map(this::createQuery)
                                         .collect(Collectors.toList());

        int index = 0;
        final int[] answer = new int[queries.size()];
        for (final Info q : queries) {
            answer[index++] = (int) infos.stream()
                                         .filter(i -> i.getScore() >= q.getScore())
                                         .filter(i -> i.isMatch(q))
                                         .count();
        }

        return answer;
    }

    private Info createInfo(final String s) {
        final String[] split = s.split(" ");
        return new Info(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]));
    }

    private Info createQuery(final String s) {
        final String[] split = s.replaceAll(" and ", " ").split(" ");
        return new Info(split[0], split[1], split[2], split[3], Integer.parseInt(split[4]));
    }

    private static class Info {
        private String language;
        private String job;
        private String career;
        private String food;
        private int score;

        public Info(final String language, final String job, final String career, final String food, final int score) {
            this.language = language;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
        }

        public boolean isMatch(final Info query) {
            if(!"-".equals(query.language) && !this.language.equals(query.language)) {
                return false;
            }

            if(!"-".equals(query.job) && !this.job.equals(query.job)) {
                return false;
            }

            if(!"-".equals(query.career) && !this.career.equals(query.career)) {
                return false;
            }

            if(!"-".equals(query.food) && !this.food.equals(query.food)) {
                return false;
            }

            return true;
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) {
        final String[] info = {"java backend junior pizza 150",
                               "python frontend senior chicken 210",
                               "python frontend senior chicken 150",
                               "cpp backend senior pizza 260",
                               "java backend junior chicken 80",
                               "python backend senior chicken 50"};
        final String[] query = {"java and backend and junior and pizza 100",
                                "python and frontend and senior and chicken 200",
                                "cpp and - and senior and pizza 250",
                                "- and backend and senior and - 150",
                                "- and - and - and chicken 100",
                                "- and - and - and - 150"};
        final int[] result = new Solution().solution(info, query);
        for (int i : result) {
            System.out.println(i);
        }
    }

}