package io.programmers.stackQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Truck {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int truck : truck_weights) {

            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if (sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }

    public static void main(String[] args) {
        int[] truck_weights = new int[]{7, 4, 5, 6};
        int bridge_length = 2;
        int weight = 10;
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

}
