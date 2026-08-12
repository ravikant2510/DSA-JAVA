class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 0;
        int left = 0;
        int pr =1;
        for(int right = 0;right<nums.length;right++) {
            pr *= nums[right];
            while(pr>=k) {
                pr = pr/nums[left];
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}