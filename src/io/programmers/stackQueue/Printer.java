package io.programmers.stackQueue;

import java.util.LinkedList;

public class Printer {

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        LinkedList<Integer> sequence = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            stack.addLast(priorities[i]);
            sequence.addLast(i);
        }

        while (true) {
            int first = stack.getFirst();
            int firstIndex = sequence.getFirst();

            boolean flag = true;

            for (int i = 1; i < stack.size(); i++) {
                if (first < stack.get(i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                if (location == firstIndex) {
                    answer++;
                    break;
                } else {
                    stack.removeFirst();
                    sequence.removeFirst();
                    answer++;
                }
            } else {
                stack.removeFirst();
                sequence.removeFirst();
                stack.addLast(first);
                sequence.addLast(firstIndex);
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }
}
