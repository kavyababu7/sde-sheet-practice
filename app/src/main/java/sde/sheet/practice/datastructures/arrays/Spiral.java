package sde.sheet.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;

public class Spiral {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
        System.out.println(matrix);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int top = 0;
        int bottom = m-1;
        int right = n-1;
        int left = 0;
        List<Integer> sp = new ArrayList();
        while (true) {
            //move right
            for (int i = left; i <= right; i++) {
                sp.add(matrix[top][i]);
            }
            top++;
            //move down
            for (int i = top; i <= bottom; i++) {
                sp.add(matrix[i][right]);
            }
            right--;
            //move left
            for (int i = right; i >= left; i--) {
                sp.add(matrix[bottom][i]);
            }
            bottom--;
            //move up
            for (int i = bottom; i <= top; i--) {
                sp.add(matrix[i][left]);
            }
            left++;
            //breaking condition
            if (top >= bottom || left >= right) {
                break;
            }
        }
        return sp;
    }
}
