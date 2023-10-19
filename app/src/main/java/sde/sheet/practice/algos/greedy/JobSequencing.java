package sde.sheet.practice.algos.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {
    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1,4,20),
                new Job(2,1,10),
                new Job(3,2,40),
                new Job(4,2,30)
        };
        maxProfit(jobs);

    }

    private static int maxProfit(Job[] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1.profit > o2.profit ? -1: 1);
        //find max deadline
        Integer maxDeadline = Arrays.stream(jobs).map(job -> job.deadline).max(Integer::compare).get();
        int[] slot = new int[maxDeadline];
        int profit = 0;
        Arrays.fill(slot, -1);
        for (int i = 0; i < jobs.length; i++) {
            Job currentJob = jobs[i];
            int index = currentJob.deadline - 1;
            while (index >= 0) {
                if (slot[index] < 0) {
                    slot[index] = currentJob.id;
                    profit += currentJob.profit;
                    break;
                }
                index--;
            }
        }
        return profit;
    }
}

class Job {
    int id;
    int deadline;
    int profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}