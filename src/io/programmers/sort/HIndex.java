package io.programmers.sort;

import java.util.Arrays;

public class HIndex {

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int h;
        for (int i = 0; i < citations.length; i++) {
            h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

}
