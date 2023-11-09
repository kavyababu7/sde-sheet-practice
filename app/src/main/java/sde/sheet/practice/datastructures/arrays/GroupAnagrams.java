package sde.sheet.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] sts = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(sts));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap();
        for(String s: strs) {
            char[] ca = new char[26];
            for (char c: s.toCharArray()){
                ca[c-'a']++;
            }
            anagramMap.computeIfAbsent(new String(ca), k -> new ArrayList()).add(s);
        }
        return new ArrayList(anagramMap.values());
    }
}
