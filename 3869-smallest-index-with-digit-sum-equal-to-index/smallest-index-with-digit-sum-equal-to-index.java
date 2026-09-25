class Solution {
    public int smallestIndex(int[] nums) {
        for(int i =0;i<nums.length;i++) {
            if(check(i,nums[i])) {
                return i;
            }
        }
        return -1;
    }
    private boolean check(int i,int n) {
        int sum =0;
        while(n>0) {
            sum += n%10;
            n = n/10;
        }
        if(sum == i) {
            return true;
        }
        return false;
    }
}