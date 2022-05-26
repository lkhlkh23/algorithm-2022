package baekjoon.Q2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int hit = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0) {
                hit++;
            }

            if(hit == k) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
