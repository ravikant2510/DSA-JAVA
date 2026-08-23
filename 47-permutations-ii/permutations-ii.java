class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list,temp,new boolean[nums.length],nums);
        return list;
    }
    private void backTrack(List<List<Integer>>list,List<Integer> temp,boolean[] used,int[] nums) {
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for(int i =0;i<nums.length;i++) {
                if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                temp.add(nums[i]);
                backTrack(list,temp,used,nums);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}