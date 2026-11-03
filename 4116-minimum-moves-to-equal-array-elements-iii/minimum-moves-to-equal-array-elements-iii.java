class Solution {
    public int minMoves(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      int moves =0;
      for(int i=0;i<nums.length-1;i++) {
        if(nums[i] < nums[n-1]) {
            moves += nums[n-1]-nums[i];
        }
      }  
      return moves;
    }
}