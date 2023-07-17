package algo_tasks;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class FoundClassmates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countryCount = scanner.nextInt();

        int[] minMoney = new int[countryCount];
        int[] education = new int[countryCount];
        int[] childrenAllowed = new int[countryCount];

        createArray(scanner, countryCount, minMoney, education, childrenAllowed);

        int countClassmates = scanner.nextInt();
        int[] classmateMoney = new int[countClassmates];
        int[] classmatesEducation = new int[countClassmates];
        int[] parentCitizen = new int[countClassmates];

        createArray(scanner, countClassmates, classmateMoney, classmatesEducation, parentCitizen);
        int[] countries = new int[countClassmates];
        for (int i =0; i < countClassmates; i++) {
            int canMigrate = 0;

            for (int j=0; j < countryCount; j++) {
                if (classmateMoney[i] >= minMoney[j] && classmatesEducation[i] == education[j]) {
                        if (parentCitizen[i] == 0 || parentCitizen[i] == j + 1 || (childrenAllowed[j] == 1 && parentCitizen[i] != 0)){
                            canMigrate = j +1;
                            break;
                        }
                    }
                }
            countries[i] = canMigrate;
        }
        for (int i =0; i < countClassmates; i++){
            System.out.print(countries[i] + " ");
        }
    }

    private static void createArray(Scanner scanner, int countClassmates, int[] classmateMoney, int[] classmatesEducation, int[] parentCitizen) {
        for (int i=0; i < countClassmates; i++) {
            classmateMoney[i] = scanner.nextInt();
        }
        for (int i=0; i < countClassmates; i++) {
            classmatesEducation[i] = scanner.nextInt();
        }
        for (int i=0; i < countClassmates; i++) {
            parentCitizen[i] = scanner.nextInt();
        }
    }
}
