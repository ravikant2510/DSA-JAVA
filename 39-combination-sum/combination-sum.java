class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combination(list,temp,candidates,target,0);
        return list;
    }
    private void combination(List<List<Integer>> list, List<Integer> temp,int[] candidates, int target,int start) {
        if(target==0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i =start;i<candidates.length;i++) {
            if(candidates[i]<=target) {
            temp.add(candidates[i]);
            combination(list,temp,candidates,target-candidates[i],i);
            temp.remove(temp.size()-1);
        }
        }
    }
}