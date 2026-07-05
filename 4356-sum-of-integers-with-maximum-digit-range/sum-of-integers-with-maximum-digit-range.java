class Solution {
    private int helper(int n) {
        int largest = 0;
        int smallest = 9;
        while(n>0) {
            int temp = n%10;
            largest = Math.max(largest,temp);
            smallest = Math.min(smallest,temp);
            n = n/10;
        }
        return largest-smallest;
    }
    public int maxDigitRange(int[] nums) {
        int[] arr = new int[nums.length];
        int max = 0;
        for(int i =0; i<nums.length;i++) {
            arr[i] = helper(nums[i]);
            max = Math.max(max,arr[i]);
        }
        int sum = 0;
        for(int i = 0; i<nums.length;i++) {
            if(max == arr[i]) {
                sum += nums[i];
            }
        }
        return sum;

    }
}