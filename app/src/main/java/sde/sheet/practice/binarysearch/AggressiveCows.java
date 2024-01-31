package sde.sheet.practice.binarysearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] tents = {0,3,4,7,10,9};
        int cows = 4;
        int maxOfMinDistance = maxOfMin(tents, cows);
        System.out.println(maxOfMinDistance);
    }

    private static int maxOfMin(int[] tents, int cows) {
        Arrays.sort(tents);
        int low = 1;
        int len = tents.length;
        int high = tents[len-1] - tents[0];
        while (high >= low) {
            int mid = (high + low)/2;
            if (canPlaceAllCows(tents, mid, cows)) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }

    private static boolean canPlaceAllCows(int[] tents, int mid, int cows) {
        int curr = tents[0];
        int cowCount = 1;
        for (int i = 1; i < tents.length; i++) {
            if (tents[i] - curr >= mid) {
                cowCount++;
                curr = tents[i];
            }
            if (cowCount >= cows) return true;
        }
        return false;
    }
}
