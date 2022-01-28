package io.programmers.hash;

import java.util.HashMap;
import java.util.Map.Entry;

public class AthletesWhoDidNotFinish {

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
