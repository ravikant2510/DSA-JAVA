class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> list = new ArrayList<>();
       List<Integer> temp = new ArrayList<>();
       backtrack(list,temp,n,1,k);
       return list;
    }
    private void backtrack(List<List<Integer>> list,List<Integer> temp, int n,int start,int k) {
        if(k==0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i =start;i<=n;i++) {
            temp.add(i);
            backtrack(list,temp,n,i+1,k-1);
            temp.remove(temp.size()-1);
        }
    }
}