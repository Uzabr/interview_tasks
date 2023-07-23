package java_chellange;

public class ReverseOrder {

    public static void main(String[] args) {
        extractDigits(-123);
    }
    private static void extractDigits(int digits) {
            if (digits < 0) {
                digits = -digits;
            }
        int remainingValue = digits;

        while (remainingValue > 0) {
            final int dig = remainingValue % 10;
            System.out.print(dig);
            remainingValue /= 10;
        }
        System.out.println();
    }
}
