package io.programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GetReportResult {

    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> resultMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        List<String> banUsers = new ArrayList<>();
        int[] answer = new int[id_list.length];

        for (String s : report) {
            String reportedId = s.split(" ")[0];
            String reportTargetId = s.split(" ")[1];

            if (!resultMap.containsKey(reportedId)) {
                resultMap.put(reportedId, new HashSet<String>());
                resultMap.get(reportedId).add(reportTargetId);
            } else {
                resultMap.get(reportedId).add(reportTargetId);
            }

            if (!reportMap.containsKey(reportTargetId)) {
                reportMap.put(reportTargetId, new HashSet<String>());
                reportMap.get(reportTargetId).add(reportedId);
            } else {
                reportMap.get(reportTargetId).add(reportedId);
            }
        }

        for (String user : reportMap.keySet()) {
            if (reportMap.containsKey(user) && reportMap.get(user).size() >= k) {
                banUsers.add(user);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            int count = 0;

            if (!resultMap.containsKey(user)) {
                continue;
            }

            for (String reportUser : resultMap.get(user)) {
                if (banUsers.contains(reportUser)) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(idList, report, k)));
    }

}
