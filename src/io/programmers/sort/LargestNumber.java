package io.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {


    public static String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 내림 차순 정렬
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (stringNumbers[0].equals("0")) {
            return "0";
        }

        return String.join("", stringNumbers);
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 30, 34, 5, 9};

        System.out.println(solution(numbers));
    }

}
