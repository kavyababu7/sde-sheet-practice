package sde.sheet.practice.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        insert(arr, new int[]{4,10});
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        for (int[] interval: intervals) {
            int newStart = newInterval[0];
            int newEnd = newInterval[1];
            int start = interval[0];
            int end = interval[1];
            if (newInterval == null || newStart > end) {
                result.add(interval);
            } else if (newEnd < start) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            } else {
                newInterval = new int[]{Math.min(newStart, start), Math.max(end, newEnd)};
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
