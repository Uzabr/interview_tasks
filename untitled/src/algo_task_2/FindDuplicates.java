package algo_task_2;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(duplicate(nums));
    }

    private static boolean duplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int count = 0;

        for (int i =0; i < nums.length; i++) {
         for (int j =i +1; j < nums.length; j++) {
             if (nums[i] == nums[j]) count++;
         }
        }

        if(count > 0 ) return true;
        return false;
    }
}
