package baekjoon.Q2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        final int a = Integer.parseInt(st.nextToken());
        final int b = Integer.parseInt(st.nextToken());
        final int v = Integer.parseInt(st.nextToken());

        int day = (v - b) / (a - b);
        if ((v - b) % (a - b) != 0) {
            day++;
        }

        System.out.println(day);
    }

}
