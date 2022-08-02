package baekjoon.Q1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(), " ");
        final int a = Integer.parseInt(st.nextToken());
        final int b = Integer.parseInt(st.nextToken());
        final int c = Integer.parseInt(st.nextToken());

        if(c - b <= 0) {
            System.out.println("-1");
        } else {
            System.out.println((a / (c - b)) + 1);
        }
    }

}
