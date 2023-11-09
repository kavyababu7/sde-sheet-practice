package sde.sheet.practice.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeInterval {

    public static void main(String[] args) {
//        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
//        int[][] arr = {{1,4},{0,4}};
        int[][] arr = {{4,5},{1,4},{0,1}};
        System.out.println(merge(arr));
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList();
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int pStart = intervals[0][0];
        int pEnd = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (pStart > intervals[i][1]) {
                result.add(intervals[i]);
            } else if (pEnd < intervals[i][0]) {
                result.add(new int[]{pStart, pEnd});
                pStart = intervals[i][0];
                pEnd = intervals[i][1];
            } else {
                pStart = Math.min(intervals[i][0], pStart);
                pEnd = Math.max(intervals[i][1], pEnd);
            }
        }
        result.add(new int[]{pStart, pEnd});
        return result.toArray(new int[result.size()][]);
    }
}
