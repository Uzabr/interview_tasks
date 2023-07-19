package algo_task_2;

import java.util.HashMap;

public class ArithmeticSlices {

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        System.out.println(numberOfArithmeticSlices(arr));
    }

    public static int numberOfArithmeticSlices(int[] arr) {
        if(arr == null  || arr.length == 0 ) return 0;

        HashMap<Integer, Integer>[] map = new HashMap[arr.length];

        map[0] = new HashMap<>();
        int result =0;
        for (int i =1; i < map.length; i++) {
            map[i] = new HashMap<>();

            for (int j =0; j < i; j++) {
                long differ = (long)arr[j] - (long)arr[i];
                if (differ >= Integer.MAX_VALUE || differ <= Integer.MIN_VALUE) continue;
                int difInt = (int) differ;

                int ci = map[i].getOrDefault(difInt, 0);
                int cj = map[j].getOrDefault(difInt, 0);

                result += cj;

                map[i].put(difInt, ci + cj + 1);
            }
        }
            return result;
    }
}
