package sde.sheet.practice.companies.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MinCostKWorkers {
    public static void main(String[] args) {
        int[] quality = {3,1,10,10,1}; int[] wage = {4,8,2,2,7}; int k = 3;
        double cost = mincostToHireWorkers(quality, wage, k);
        System.out.println(cost);
    }
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        TreeSet<Integer> oneMap = new TreeSet();
        List<Pair> workers = new ArrayList();
        for (int i = 0 ; i < quality.length; i++) {
            workers.add(new Pair(quality[i], wage[i]/quality[i]));
        }
        Collections.sort(workers, Comparator.comparingDouble(w -> w.ratio));
        double result = Double.MAX_VALUE;
        double totalQuality = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (Pair worker: workers) {
            pq.add(worker.quality);
            totalQuality += worker.quality;
            if (pq.size() > k) {
                totalQuality -= pq.remove();
            }
            if (pq.size() == k) {
                result = Math.min(result, totalQuality*worker.ratio);
            }
        }
        return result;
    }
}
class Pair {

    int quality;
    double ratio;

    Pair(int quality, double ratio) {
        this.quality = quality;
        this.ratio = ratio;
    }

}