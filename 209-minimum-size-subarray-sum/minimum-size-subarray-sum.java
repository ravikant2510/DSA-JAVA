class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // int ans = Integer.MAX_VALUE;
        // for(int i = 0;i<nums.length;i++) {
        //     int sum = 0;
        //     for(int j = i;j<nums.length;j++) {
        //         sum += nums[j];
        //         if(sum >= target) {
        //             ans = Math.min(ans, j - i + 1);
        //             break;
        //         }
        //     }
        // }
        // return ans == Integer.MAX_VALUE ? 0 : ans;

        int sum = 0; 
        int left = 0;
        int ans = Integer.MAX_VALUE;
        for(int right=0; right<nums.length;right++) {
            sum += nums[right];
            while(sum >= target) {
                sum -= nums[left];
                ans = Math.min(ans,right-left+1);
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}