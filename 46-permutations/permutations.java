class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(list,temp,nums);
        return list;
    }
    private void backTrack(List<List<Integer>> list, List<Integer> temp , int[] nums) {
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for(int i=0;i<nums.length;i++) {
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(list,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}