import java.util.*;

class Solution {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        // Step 1: Sort each row
        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
        }

        int sum = 0;

        // Step 2: Traverse column-wise from right to left
        for (int col = n - 1; col >= 0; col--) {
            int max = 0;
            for (int row = 0; row < m; row++) {
                max = Math.max(max, nums[row][col]);
            }
            sum += max;
        }

        return sum;
    }
}
