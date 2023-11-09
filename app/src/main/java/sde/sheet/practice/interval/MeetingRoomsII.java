package sde.sheet.practice.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {{20,30},{10,40},{5,50}};
        int meetingRooms = minMeetingRooms(intervals);
        System.out.println(meetingRooms);
    }

    private static int minMeetingRooms(int[][] intervals) {
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();
        for (int[] interval : intervals) {
            startTimes.add(interval[0]);
            endTimes.add(interval[1]);
        }
        Collections.sort(startTimes);
        Collections.sort(endTimes);
        int count = 0;
        int maxRooms = 0;
        int sIdx = 0;
        int eIdx = 0;
        while (sIdx < intervals.length) {
            if (startTimes.get(sIdx) < endTimes.get(eIdx)) {
                count++;
                sIdx++;
            } else {
                count--;
                eIdx++;
            }
            maxRooms = Math.max(count, maxRooms);
        }
        return maxRooms;
    }
}
