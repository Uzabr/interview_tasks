package algo_task_2;

public class PalindromNumber {
    public static void main(String[] args) {
        int x = 123;
        int n = (x / 10) % 10;
        System.out.println(n);
    }

    private static boolean palindromeNumber(int x) {
        if(x  < 0) return false;

        int left = 1;

        while (x / left >= 10) {
            left *= 10;
        }

        int right = 1;
        while (left > right) {
            if ((x / left ) % 10  != (x/right) % 10) return false;

            left /=10;
            right *= 10;
        }

        return true;
    }
}
