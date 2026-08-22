class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(list,temp,nums,0);
        return list;
    }
    private void backtrack(List<List<Integer>>list,List<Integer> temp , int[] nums,int start) {
        list.add(new ArrayList<>(temp));
        Arrays.sort(nums);
        for(int i = start;i<nums.length;i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}