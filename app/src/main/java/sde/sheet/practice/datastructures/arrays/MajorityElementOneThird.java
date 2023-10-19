package sde.sheet.practice.datastructures.arrays;

public class MajorityElementOneThird {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 2};
        System.out.println(majorityByVoting(nums));
    }

    private static int[] majorityByVoting(int[] nums) {
        int element1 =0;
        int element2 =0;
        int count1=0;
        int count2=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != element1 && count2 == 0) {
                element2 = nums[i];
                count2++;
            } else if (nums[i] != element2 && count1 == 0) {
                element1 = nums[i];
                count1++;
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        System.out.println(element1);
        System.out.println(element2);
        return null;
    }
}
