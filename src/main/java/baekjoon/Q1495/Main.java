package baekjoon.Q1495;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String[] first = scanner.nextLine().split(" ");
        final List<Integer> volumes = Arrays.stream(scanner.nextLine().split(" "))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toUnmodifiableList());
        final int n = Integer.parseInt(first[0]);
        final int m = Integer.parseInt(first[1]);
        final int s = Integer.parseInt(first[2]);

        System.out.println(dfs(volumes, m, s));
    }

    private static int dfs(final List<Integer> volumes, final int start, final int max) {
        final Stack<Volume> stack = new Stack<>();
        stack.add(new Volume(0, start + volumes.get(0)));
        stack.add(new Volume(0, start - volumes.get(0)));

        final boolean[][] visited = new boolean[volumes.size() + 1][max + 1];

        int maxVolume = -1;
        while (!stack.isEmpty()) {
            final Volume volume = stack.pop();
            if(volume.size > max || volume.size < 0 || visited[volume.index][volume.size]) {
                continue;
            }

            if(volume.index == volumes.size() - 1) {
                maxVolume = Math.max(maxVolume, volume.size);
                continue;
            }

            visited[volume.index][volume.size] = true;
            stack.push(new Volume(volume.index + 1, volume.size + volumes.get(volume.index + 1)));
            stack.push(new Volume(volume.index + 1, volume.size - volumes.get(volume.index + 1)));
        }

        return maxVolume;
    }

    private static class Volume {
        private int index;
        private int size;

        public Volume(int index, int size) {
            this.index = index;
            this.size = size;
        }
    }
}
