package io.programmers.sort;

import java.util.Arrays;
import java.util.Collections;

public class KthNumber {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;

        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int target = command[2];

            int[] copy = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(copy);
            answer[cnt++] = copy[target - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution(array, commands);
        for (int x : answer) {
            System.out.printf("%d ", x);
        }

    }
}
