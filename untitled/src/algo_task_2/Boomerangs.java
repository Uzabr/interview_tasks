package algo_task_2;

import java.util.HashMap;
import java.util.Map;

public class Boomerangs {
/*
You are given n points in the plane that are all distinct, where points[i] = [xi, yi].
A boomerang is a tuple of points (i, j, k)
such that the distance between i and j equals the distance between i and k (the order of the tuple matters)
 */

    //первый вариант
    private static int numberOfBoomerangs(int[][] arr) {
        int count =0;

        for (int i = 0; i < arr.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j =0; j < arr.length; j++) {
                int d = (arr[j][0] - arr[i][0]) * (arr[j][0] - arr[i][0]) + (arr[j][1] - arr[i][1]) * (arr[j][1] - arr[i][1]);
                if (!map.containsKey(d)) {
                    map.put(d, 1);
                }
                else {
                    map.put(d, map.get(d) + 1);
                }
            }

            for (Integer sum : map.keySet()) {
                count += map.get(sum) * (map.get(sum) -1);
            }
        }
        return count;
    }

    //второй вариант

    private static int numberOfBoomerangs_2(int[][] points) {
        int count =0;

        for (int i =0; i < points.length; i++){
            Map<Integer, Integer> map = new HashMap<>();
            for (int j =0; j < points.length; j++) {
                    if (i != j) {
                        int d = calculateDistance(points[i], points[j]);
                        map.put(d, map.getOrDefault(d, 0) + 1);
                    }
            }

            for (int k : map.values()) {
                count += k * (k -1);
            }
        }
        return count;
    }

    private static int calculateDistance(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        return dx * dx + dy * dy;
    }
}

