package sde.sheet.practice.datastructures.arrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,2,3,3};
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        for (int k = 0; k < i + 1; k++) {
            System.out.println(arr[k]);
        }
    }
}
