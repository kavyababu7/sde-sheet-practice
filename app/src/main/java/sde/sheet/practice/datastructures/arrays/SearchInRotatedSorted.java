package sde.sheet.practice.datastructures.arrays;

public class SearchInRotatedSorted {
    public static void main(String[] args) {
//        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
////        int search = 8;
////        int search = 4;
//        int search = 9;
        int[] nums = {3, 4, 5, 6, 7, 8, 1, 2};
//                int search = 8;
//        int search = 4;
        int search = 9;
        boolean isPresent = searchInRotatedArray(nums, search);
        System.out.println(isPresent);
    }

    private static boolean searchInRotatedArray(int[] nums, int search) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            //is left sorted
            boolean rightSorted = nums[start] <= nums[mid];
            if (rightSorted) {
                //element in left area
                if (search == nums[mid]) {
                    return true;
                } else if (search >= nums[start] && search < nums[mid]) { //element within left
                    end = mid;
                } else { //element in right area
                    start = mid + 1;
                }
            } else { //right sorted
                if (search == nums[mid]) {
                    return true;
                } else if (search >= nums[mid] && search <= nums[end]) { //element within right
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
