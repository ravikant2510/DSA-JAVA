class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTrack(list,temp,candidates,target,0);
        return list;
    }
    private void backTrack(List<List<Integer>> list, List<Integer> temp,int[] candidates,int target,int start) {
        if(target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start;i<candidates.length;i++) {
          if(i>start && candidates[i] == candidates[i-1]) {
            continue; 
          }

          if(candidates[i]>target) {
            break;
          }
            temp.add(candidates[i]);
            backTrack(list,temp,candidates,target-candidates[i],i+1);
            temp.remove(temp.size()-1);
        }
    }
}