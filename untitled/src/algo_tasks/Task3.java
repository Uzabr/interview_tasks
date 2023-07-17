package algo_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
        }

        List<Pair> transactions = findOptimalTransactions(prices);

        System.out.println(transactions.size());
        for (Pair transaction : transactions) {
            System.out.println(transaction.buyDay + " " + transaction.sellDay);
        }
    }

    static class Pair {
        int buyDay;
        int sellDay;

        Pair(int buyDay, int sellDay) {
            this.buyDay = buyDay;
            this.sellDay = sellDay;
        }
    }

    public static List<Pair> findOptimalTransactions(int[] prices) {
        List<Pair> transactions = new ArrayList<>();
        int N = prices.length;

        int buyDay = -1;
        int sellDay = -1;

        for (int i = 0; i < N - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                if (buyDay == -1) {
                    buyDay = i + 1;
                }
            } else if (prices[i] > prices[i + 1]) {
                if (buyDay != -1) {
                    sellDay = i + 1;
                    transactions.add(new Pair(buyDay, sellDay));
                    buyDay = -1;
                    sellDay = -1;
                }
            }
        }

        if (buyDay != -1 && sellDay == -1) {
            transactions.add(new Pair(buyDay, N));
        }

        while (transactions.size() > 2) {
            removeLeastTransaction(transactions, prices);
        }

        return transactions;
    }

    private static void removeLeastTransaction(List<Pair> transactions, int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int indexToRemove = -1;

        for (int i = 0; i < transactions.size(); i++) {
            Pair transaction = transactions.get(i);
            int profit = prices[transaction.sellDay - 1] - prices[transaction.buyDay - 1];

            if (profit < minProfit) {
                minProfit = profit;
                indexToRemove = i;
            }
        }
        transactions.remove(indexToRemove);
    }
}
