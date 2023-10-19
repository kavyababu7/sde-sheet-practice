package sde.sheet.practice.algos.greedy;

import java.util.Arrays;

public class NumberOfPlatforms {
    public static void main(String[] args) {
        int arr[]={900,945,955,1100,1500,1800};
        int dep[]={920,1200,1130,1150,1900,2000};
        System.out.println(numberOfPlatformsBrute(arr, dep));
        System.out.println(numberOfPlatformsOptimized(arr, dep));
    }

    private static boolean numberOfPlatformsOptimized(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int maxPlatforms = 1;
        int arrPtr = 1;
        int depPtr = 0;
        int platforms = 1;
        while (arrPtr < arr.length && depPtr < arr.length) {
            if (arr[arrPtr] <= dep[depPtr]) {
                platforms++;
                arrPtr++;
            } else {
                platforms--;
                depPtr++;
            }
            maxPlatforms = Math.max(platforms, maxPlatforms);
        }
        System.out.println(maxPlatforms);
        return false;
    }

    private static int numberOfPlatformsBrute(int[] arr, int[] dep) {
        int maxPlatforms = 1;
        for (int first = 0; first < arr.length; first++) {
            int count = 1;
            for (int next = first+1; next < arr.length; next++) {
                if (((arr[first] >= arr[next]) && (arr[first] < dep[next])) ||
                        ((arr[next] >= arr[first]) && arr[next] < dep[first])) {
                    count++;
                    maxPlatforms = Math.max(maxPlatforms, count);
                } else {
                    count--;
                }
            }
        }
        return maxPlatforms;
    }
}
