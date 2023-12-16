package sde.sheet.practice.companies.google;

import static java.lang.Long.MAX_VALUE;

public class KEmptySlots {
    public static void main(String[] args) {
        int[] bulbs = {2,5,6,3,4,1};
        System.out.println(emptySlots(bulbs, 2));
    }

    private static int emptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        int[] positions = new int[n + 1];
        for (int i = 0; i < n; i++)
            positions[bulbs[i]] = i + 1;
        int start = 1;
        int end = k + 2;
        int result = Integer.MAX_VALUE;
        int i = 0;
        while (end <= n) {
            i++;
            if (positions[i] > positions[start] && positions[i] > positions[end]) {
                continue;
            }
            result = Math.min(result, Math.max(positions[start], positions[end]));
            start = i;
            end = i + k + 1;
        }
        return result==MAX_VALUE?-1:result;
    }
}
