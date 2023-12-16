package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) {
            return new ArrayList();
        }
        String[] combinations = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> results = new ArrayList();
        getCombinations(digits, "", combinations, results);
        return results;
    }


    private static void getCombinations(String digits, String tempStr, String[] combinations, List<String> results){
        if (tempStr.length() == digits.length()) {
            results.add(tempStr);
            return;
        }
        if (tempStr.length() > digits.length()) {
            return;
        }
        String keys = combinations[digits.charAt(tempStr.length())-'0'];
        for (char ch: keys.toCharArray()) {
            getCombinations(digits, tempStr+ch, combinations, results);
        }
    }
}
