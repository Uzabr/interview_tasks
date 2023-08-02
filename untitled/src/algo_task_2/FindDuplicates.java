package algo_task_2;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1};
        System.out.println(duplicate(nums));
    }

    private static boolean duplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;

        Set<Integer>  set = new HashSet<>();
        for (int i : nums) {
         if (!set.add(i)) {
             return true;
         }
        }
        return false;
    }
}
