package sde.sheet.practice.algos.greedy;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int amount = 98;
        getChange(coins, amount);
    }

    private static Map<Integer, Integer> getChange(int[] coins, int amount) {
        int index = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] < amount) {
                index = i;
                break;
            }
        }
        Map<Integer, Integer> coinChangeMap = new HashMap<>();
        while (amount > 0) {
            if (coins[index] <= amount) {
                amount -= coins[index];
                coinChangeMap.merge(coins[index], 1, Integer::sum);
            } else {
                index--;
            }
        }
        return coinChangeMap;
    }
}
