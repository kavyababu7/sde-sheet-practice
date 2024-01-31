package sde.sheet.practice.companies.google;

import java.util.TreeSet;

public class MaximiseDistance {
    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        TreeSet<Integer> oneSet = new TreeSet();
        for (int i = 0 ; i < seats.length; i++) {
            if(seats[i] == 1) {
                oneSet.add(i);
            }
        }
        int dist = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0 ; i < seats.length; i++) {
            if (seats[i] == 0) {
                Integer ceil = oneSet.ceiling(i) == null? Integer.MAX_VALUE: oneSet.ceiling(i);
                Integer floor = oneSet.floor(i) == null? Integer.MAX_VALUE: oneSet.floor(i);
                int maxVal = Math.min(Math.abs(ceil-i), Math.abs(floor-i));
                if (dist < maxVal) {
                    dist = maxVal;
                    idx = i;
                }
            }
        }
        System.out.println(idx);
    }


}
