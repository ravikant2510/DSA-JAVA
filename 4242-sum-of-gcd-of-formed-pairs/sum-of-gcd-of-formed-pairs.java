class Solution {
    public long gcdSum(int[] nums) {
      int max = nums[0];
      for(int i = 1;i<=nums.length-1;i++) {
        max = Math.max(nums[i],max);
        nums[i]= gcd(max,nums[i]);
      }  
      long sum =0;
      int left = 0;
      int right = nums.length-1;
      Arrays.sort(nums);
      while(left<right) {
        if(left != right) {
            sum += gcd(nums[left],nums[right]);
        }
        left++;
        right--;
      }
      return sum;
    }
    private int gcd(int a, int b) {
        if( b==0) {
            return a;
        }
        return gcd(b,a%b);
    }
}