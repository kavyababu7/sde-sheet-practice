package sde.sheet.practice.datastructures.trie;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        String a = "abcdfs";
        List<String> list =  getAllSubsequences(a);
        System.out.println(list);
    }

    private static List<String> getAllSubsequences(String a) {
        int n = a.length();
        //0 -> 2^n-1
        List<String> subSequences = new ArrayList<>();
        for (int i = 0; i < (1 << n) - 1; i++) {
            String sub = "";
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    sub += a.charAt(j);
                }
            }
            subSequences.add(sub);
        }
        return subSequences;
    }
}
