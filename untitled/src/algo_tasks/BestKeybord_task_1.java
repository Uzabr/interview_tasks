package algo_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class BestKeybord_task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int keyCounts = scanner.nextInt();
        int[] keyIdentity = new int[keyCounts];
        int[] rows = new int[keyCounts];

        for (int i=0; i < keyCounts; i++) {
            keyIdentity[i] = scanner.nextInt();
        }

        for (int j =0; j < keyCounts; j++) {
            rows[j] = scanner.nextInt();
        }

        int refSymbols = scanner.nextInt();
        int[] refSymbolsIdentity = new int[refSymbols];

        for (int k = 0; k < refSymbols; k++) {
            refSymbolsIdentity[k] = scanner.nextInt();
        }

        Map<Integer, Integer> mapSymbols= new HashMap<>();
        for (int i =0; i < keyCounts; i++) {
            mapSymbols.put(keyIdentity[i], rows[i]);
        }
        int counter=0;
        int prevSym = mapSymbols.get(refSymbolsIdentity[0]);
        for (int i=1; i < refSymbolsIdentity.length; i++){
            int currentSym= mapSymbols.get(refSymbolsIdentity[i]);
            if (!Objects.equals(mapSymbols.get(currentSym), mapSymbols.get(prevSym))) {
                counter++;
            }
            prevSym = currentSym;
        }

        System.out.println(counter);
    }
}
