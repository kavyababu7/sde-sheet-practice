package sde.sheet.practice.algos.binarysearch;

public class KthSmallestInTwoSortedArrays {
    public static void main(String[] args) {
        int array1[] = {2,3,6,7,9};
        int array2[] = {1,4,8,10};
        int len1 = array1.length;
        int len2 = array2.length;
        int k = 5;
        int kSmall = kthSmallestInArrays(array1, array2, len1, len2, k);
        System.out.println(kSmall);
    }

    private static int kthSmallestInArrays(int[] array1, int[] array2, int len1, int len2, int k) {
        /**

         236 l1 | 79 r1    (l2 <= r1)
         14  l2 | 810 r2   (l1 <= r2) l1 -></=>
         *
         *
         *
         */
        return 0;
    }
}
