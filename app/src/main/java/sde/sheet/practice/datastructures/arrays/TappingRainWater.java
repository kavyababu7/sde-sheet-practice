package sde.sheet.practice.datastructures.arrays;

public class TappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int maxWaterBrute = tapByBrute(heights);
        int maxWaterBetter = tapByBetter(heights);
        int maxWaterOptimal = tapByOptimal(heights);
        System.out.println("volume by brute = " + maxWaterBrute);
        System.out.println("volume by better = " + maxWaterBetter);
        System.out.println("volume by optimal = " + maxWaterOptimal);
    }

    private static int tapByOptimal(int[] heights) {
        int volume = 0;
        int rightMax = 0;
        int leftMax = 0;
        int left = 0; int right = heights.length - 1;
        while (left < right) {
            if (heights[left] < heights[right]) {
                if (heights[left] > leftMax) {
                    leftMax = heights[left];
                } else {
                    volume += leftMax - heights[left];
                }
                left++;
            } else {
                if (heights[right] > rightMax) {
                    rightMax = heights[right];
                } else {
                    volume += rightMax - heights[right];
                }
                right--;
            }
        }
        return volume;
    }
    private static int tapByBetter(int[] heights) {
        int i = 1;
        int volume = 0;
        int[] prefixMaximum = new int[heights.length];
        int[] suffixMaximum = new int[heights.length];
        while (i < heights.length) {
            prefixMaximum[i] = Math.max(heights[i], prefixMaximum[i-1]);
            i++;
        }
        int j = heights.length - 2;
        suffixMaximum[j+1] = heights[heights.length-1];
        while (j >= 0) {
            suffixMaximum[j] = Math.max(heights[j], suffixMaximum[j+1]);
            j--;
        }
        for (int k = 0; k < heights.length; k++) {
            volume += Math.min(prefixMaximum[k], suffixMaximum[k]) - heights[k];
        }
        return volume;
    }

    private static int tapByBrute(int[] heights) {
        int volume = 0;
        for (int i = 0; i < heights.length; i++) {
            int leftMaximum = 0;
            int j = i ;
            while (j >= 0) {
                leftMaximum = Math.max(leftMaximum, heights[j]);
                j--;
            }
            int rightMaximum = 0;
            int k = i ;
            while (k < heights.length) {
                rightMaximum = Math.max(rightMaximum, heights[k]);
                k++;
            }
            volume+= Math.min(leftMaximum, rightMaximum) - heights[i];
        }
        return volume;
    }
}
