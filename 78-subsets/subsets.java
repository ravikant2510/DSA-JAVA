class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(result,temp,nums,0);
        return result;
    }
    public void backtrack(List<List<Integer>> list,List<Integer>temp,int[] nums,int start) {
        list.add(new ArrayList<>(temp));
        int n = nums.length;
        for(int i=start;i<n;i++) {
            temp.add(nums[i]);
            backtrack(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}