package io.programmers.stackQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DevelopFunction {

    public static int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] answer = new int[progresses.length];
        int cnt = 0;

        for (int i = 0; i < progresses.length; i++) {
            int remainingPeriod = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (stack.size() == 0) {
                stack.push(remainingPeriod);
                answer[cnt]++;
            } else {
                int last = stack.getLast();
                if (last < remainingPeriod) {
                    stack.addLast(remainingPeriod);
                    answer[++cnt]++;
                } else {
                    answer[cnt]++;
                }
            }
        }

        return Arrays.stream(answer).filter(x -> x > 0).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
}
