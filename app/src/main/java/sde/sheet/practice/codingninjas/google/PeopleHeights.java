package sde.sheet.practice.codingninjas.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleHeights {
    public static void main(String[] args) {
        int[] heights = {5, 3, 2, 6, 1, 4};
        int[] inFronts = {0, 1, 2, 0, 3, 2};
        int[] heightsSorted = orderPeopleHeightsInFront(heights, inFronts);
    }

    private static int[] orderPeopleHeightsInFront(int[] heights, int[] inFronts) {
        List<List<Integer>> heightInfrontsList = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(heights[i]);
            nums.add(inFronts[i]);
            heightInfrontsList.add(nums);
        }
        Collections.sort(heightInfrontsList, Comparator.comparing(a -> a.get(0)));
        int[] result = new int[heights.length];
        Arrays.fill(result, -1);
        for (List<Integer> heightInfrontList : heightInfrontsList) {
            int j;
            int count = -1;
            for (j = 0; j < heights.length; j++) {
                if (result[j] == -1) {
                    count++;
                }
                if (count == heightInfrontList.get(1)) {
                    break;
                }
            }
            result[j] = heightInfrontList.get(0);
        }
        //[1->3],[2->2],[3->1],[4->2],[5->0],[6->0]
        //empty = [0,1,2,3,4,5]

        return result;
    }
}
