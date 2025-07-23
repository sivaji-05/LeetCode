class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums); 
        int n = nums.length;
        int count = 1; 
        int current = nums[n - 1];

        
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != current) {
                count++;
                current = nums[i];
            }
            if (count == 3) {
                return current;
            }
        }

        
        return nums[n - 1];

    }
}