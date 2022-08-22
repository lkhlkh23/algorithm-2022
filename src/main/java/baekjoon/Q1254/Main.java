package baekjoon.Q1254;

import java.util.Scanner;

public class Main {

    // not completed

    public static void main(String[] args) {
        final char[] inputs = "abdfhdyrbdbsdfghjkllkjhgfds".toCharArray(); // new Scanner(System.in).nextLine().toCharArray();
        System.out.println(inputs.length + "~~~~");
        int start = 0;
        int end = inputs.length - 1;
        String str = "";

        while(start != end) {
            if(inputs[start] != inputs[end] || start <= end) {
                str = (String.valueOf(inputs[start]) + str);
                start++;
            } else {
                start++;
                end--;
            }
        }

        for (char input : inputs) {
            System.out.print(input);
        }
        System.out.println(str);
        System.out.println(inputs.length + str.length());

        // abs dfhdyrbdbsdfghjkllkjhgfds ba
    }
}
