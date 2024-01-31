package sde.sheet.practice.companies.google;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class NextClosestTime {
    public static void main(String[] args) {
//        String time = "23:59";
        String time = "01:34";
        System.out.println(nexClosestTime(time));
    }

    private static String nexClosestTime(String time) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        List<Integer> timeList = new ArrayList<>();
        for (int i = 0 ; i < time.length(); i++) {
            if (i == 2) continue;
            treeSet.add(time.charAt(i)-'0');
            timeList.add(time.charAt(i)-'0');
        }
        for (int i = 3; i >= 0; i--) {
            int place = timeList.get(i);
            Integer higher = treeSet.higher(place);
            if (higher == null || isAlreadyHigher(place, i) || isInValid(higher, i)) {
                timeList.set(i, treeSet.first());
            } else if (higher != null) {
                timeList.set(i, higher);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(timeList.get(i));
            if(i == 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    private static boolean isInValid(int higher, int idx) {
        if ((idx == 0 && higher > 2) || (idx == 1  && higher > 4) || (idx == 2 && higher > 5)) {
            return true;
        }
        return false;
    }

    private static boolean isAlreadyHigher(int place, int idx) {
        if ((idx == 0 && place ==2) || (idx == 1  && place == 4) || (idx == 2 && place == 5) || (idx == 3 && place == 9)) {
            return true;
        }
        return false;
    }
}
