package io.programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberList {

    public static boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] phoneBook = new String[]{"119", "97674223", "1195524421"};
        System.out.println(solution(phoneBook));
    }
}
