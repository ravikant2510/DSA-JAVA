class Solution {
    public int minMoves(int[] nums) {
      int max =0;
      int moves =0;
      int sum =0;
      for(int i=0;i<nums.length;i++) {
        max = Math.max(max,nums[i]);
        sum += nums[i];
      }  
      return (nums.length*max)-sum;
    }
}