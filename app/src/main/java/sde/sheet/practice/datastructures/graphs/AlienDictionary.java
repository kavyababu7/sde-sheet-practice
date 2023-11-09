package sde.sheet.practice.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] dict = {"baa","abcd","abca","cab","cad"};
        String order = getOrderInAlienDictionary(dict, 4);
    }

    private static String getOrderInAlienDictionary(String[] dict, int noOfLetters) {
        int[] adjList = new int[noOfLetters];
        Arrays.fill(adjList, -1);
        for (int i = 0; i < dict.length - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i+1];
            int minLen = Math.min(word2.length(), word1.length());
            //edge case: abc, abck <- this will always give incorrect order
            for (int j = 0; j < minLen; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList[word1.charAt(j)-'a'] = word2.charAt(j)-'a';
                }
            }
        }

        return null;
    }
}
