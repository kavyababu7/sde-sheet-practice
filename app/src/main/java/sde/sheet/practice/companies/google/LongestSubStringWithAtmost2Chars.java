package sde.sheet.practice.companies.google;

public class LongestSubStringWithAtmost2Chars {
    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(longestSubString(s));
    }

    private static int longestSubString(String s) {
        char lastCh = '\0';
        char secondLastCh = '\0';
        int lastCount = 0;
        int currMaxLen = 0;
        int maxLen = 0;
        for (char ch: s.toCharArray()){
            if (ch == lastCh || ch == secondLastCh) {
                currMaxLen++;
            } else {
                currMaxLen = lastCount + 1;
            }
            if (ch == lastCh) {
                lastCount++;
            } else  {
                lastCount = 1;
            }

            if (ch != lastCh) {
                secondLastCh = lastCh;
                lastCh = ch;
            }
            maxLen = Math.max(currMaxLen, maxLen);
        }

        return maxLen;
    }
}
