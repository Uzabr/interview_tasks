package algo_tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EqualizeVolumes {


    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int len;
         len = scn.nextInt();
            int[] arr = new int[len];
        for (int i=0; i<len; i++){
            arr[i] = scn.nextInt();
        }


        int maxV = maxVolumeOf(arr);
        if (possible(arr, maxV, len)) {
            System.out.println( minimizeOperations(arr, maxV, len));

        }
        else {
            System.out.println(-1);
        }


    }
    public static int maxVolumeOf(int arr[]){
        int maxVolume = Integer.MIN_VALUE;
        for (int volume : arr) {
            if (volume > maxVolume) {
                maxVolume = volume;
            }
        }
        return maxVolume;
    }

    public static boolean possible(int arr[], int maxValue, int k) {
        for (int volumes : arr) {
            if ((maxValue - volumes) % k == 0) {
                return false;
            }
        }
        return true;
    }

    public static int minimizeOperations(int arr[], int maxV, int k){
            int operations = 0;
            for (int i=0; i<k; i++){
                operations += (maxV - arr[i]) / k;
            }
            return operations;
    }
}
