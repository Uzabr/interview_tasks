package algo_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perficsionist {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int countSk = read.nextInt();
        int idealCountSk = read.nextInt();
        int last_time = read.nextInt();

        int[] sculptures = new int[countSk];

        for (int i=0; i < countSk; i++) {
            sculptures[i] = read.nextInt();
        }
        int maxSculpture = maxSculptures(countSk, idealCountSk, last_time, sculptures);
        System.out.println(maxSculpture);

        if (maxSculpture > 0) {
            List<Integer> listSculptures = idealSculptures(countSk, idealCountSk, last_time, sculptures);
         for (int i=0; i<listSculptures.size(); i++) {
             System.out.print(listSculptures.get(i));
             if (i != listSculptures.size() -1) {
                 System.out.print(" ");
             }
         }

        }


    }
    public static int maxSculptures(int countSk, int idealCountSk, int time, int[] sculptures) {
        int maxS = 0;

        for (int i = 0; i < countSk; i++) {
            if (idealCountSk + time >= sculptures[i] && time >= (idealCountSk + sculptures[i])/2){
                maxS++;
            }
        }
        return maxS;
    }

    public static List<Integer> idealSculptures(int countSk, int idealCountSk, int time, int[] sculptures){

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < countSk; i++) {
            if (idealCountSk + time  >= sculptures[i] && time >= (idealCountSk + sculptures[i])/2){
                list.add(i + 1);
            }
        }
        return list;
    }
}
