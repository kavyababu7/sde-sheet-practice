package sde.sheet.practice.datastructures.arrays;

public class BestBuyAndSell {
    public static void main(String[] args) {
        int[] dailyPrices = {7,1,5,3,6,4};
        System.out.println(brute(dailyPrices));
        System.out.println(optimal(dailyPrices));

    }

    private static int optimal(int[] dailyPrices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < dailyPrices.length; i++) {
            minPrice = Math.min(minPrice, dailyPrices[i]);
            maxProfit = Math.max(maxProfit, dailyPrices[i] - minPrice);
        }
        return maxProfit;
    }

    private static int brute(int[] dailyPrices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < dailyPrices.length; i++) {
            for (int j = i; j < dailyPrices.length; j++) {
                maxProfit = Math.max(maxProfit, dailyPrices[j]-dailyPrices[i]);
            }
        }
        return maxProfit;
    }
}
