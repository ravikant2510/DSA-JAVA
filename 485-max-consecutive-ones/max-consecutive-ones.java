class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count1 = 0;
        int max =0;
        for(int i =0;i<nums.length;i++){       
            if(nums[i] == 0) {   
                count1 =0;
            }else {
                count1++;
                max = Math.max(count1,max);
            }
        }
        return max;
    }
}