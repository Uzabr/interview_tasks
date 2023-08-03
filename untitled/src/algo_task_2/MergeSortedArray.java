package algo_task_2;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};

        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        m--;
        n--;

        for (int i = m + n + 1; i>=0; i--) {
            int a = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            int b = n >= 0 ? nums2[n] : Integer.MIN_VALUE;
            if (a > b) {
                nums1[i] = a;
                m--;
            }
            else {
                nums1[i] = b;
                n--;
            }
        }
    }
}
