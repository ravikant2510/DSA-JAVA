class Solution {
    public int missingInteger(int[] nums) {
        // int sum = nums[0];
        // int n = nums.length;
        // for(int i = 1;i<n;i++) {
        //     if(nums[i]==nums[i-1]+1) {
        //         sum += nums[i];
        //     } else {
        //         break;
        //     }
        // }
        // Arrays.sort(nums);
        // for(int i =0;i<n;i++) {
        //     if(sum == nums[i]) {
        //         sum++;
        //     }
        // }
        // return sum;

        int n = nums.length;
        boolean[] check = new boolean[52];
        int sum =nums[0];
        boolean seq = true;
        check[nums[0]] = true;
        for(int i = 1;i<n;i++) {
            if(seq && nums[i] == nums[i-1]+1) {
                sum += nums[i];
            } else {
                seq = false;
                if(sum > 50){
                    return sum;
                }
            }
            check[nums[i]] = true;
        }
        for(int i = sum;i<52;i++) {
            if(!check[i]) {
                return i;
            }
        }
        return sum;
    }
}