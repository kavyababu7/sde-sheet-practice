package sde.sheet.practice.companies.google;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
    public static void main(String[] args) {
        int[] A = {5,1,3,4,2};
        int goodStarts = oddEven(A);
        System.out.println(goodStarts);
    }

    private static int oddEven(int[] A) {
        int n = A.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n-1] = true; lower[n-1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n-1], n-1);
        int count = 1;
        for (int i = n-2; i >= 0; i--) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> lo = map.floorEntry(A[i]);
            if (hi != null) {
                higher[i] = lower[hi.getValue()];
            }
            if (lo != null) {
                lower[i] = higher[lo.getValue()];
            }
            if (higher[i]) count++;
            map.put(A[i],i);
        }
        return count;
    }
}
