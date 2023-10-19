package sde.sheet.practice.algos.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInARoom {

    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,5,7,9,9};
        List<Meeting> meetings = new ArrayList<>();
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i], i));
        }
        meetings.sort(Comparator.comparing((Meeting meeting) -> meeting.end).thenComparing(meeting -> meeting.position));
        int limit = meetings.get(0).end;
        answers.add(meetings.get(0).position);
        for (int i = 1; i < start.length; i++) {
            if (meetings.get(i).start > limit) {
                answers.add(meetings.get(i).position);
                limit = meetings.get(i).end;
            }
        }
        System.out.println(answers);
    }
}

class Meeting{
    int start;
    int end;
    int position;

    public Meeting(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}