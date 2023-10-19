package sde.sheet.practice.algos.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int values[] = {100,60,120};
        int weights[] = {20,10,30};
        int weight = 50;
        int totalValue = 0;
        List<Pair> items = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            items.add(new Pair(values[i], weights[i]));
        }
        Collections.sort(items, (p1, p2) -> p1.value/p1.weight > p2.value/p2.weight ? -1 : 1);

        for (Pair pair: items) {
            if (weight > 0) {
                if (weight < pair.weight) {
                    totalValue += (pair.value / pair.weight) * weight;
                    weight = 0;
                } else {
                    weight -= pair.weight;
                    totalValue += pair.value;
                }
            }
        }
        System.out.println(totalValue);
    }
}

