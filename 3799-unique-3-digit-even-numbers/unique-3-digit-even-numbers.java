class Solution {
    Set<Integer> set = new HashSet<>();
    public int totalNumbers(int[] digits) {
        boolean[] visited = new boolean[digits.length];
        backtrack(digits,0,0,visited);
        return set.size();
    }
    private void backtrack(int[] digits,int count,int num,boolean visited[]) {
        if(count == 3) {
            if(num%2 == 0) {
                set.add(num);
            }
            return;
        }
        for(int i =0;i<digits.length;i++) {
            if(visited[i]) {
                continue;
            }
            if (count == 0 && digits[i] == 0) continue;
             visited[i] = true;
             num = num * 10 + digits[i];
             backtrack(digits,count+1,num,visited);
             
             visited[i] = false;
             num = num/10;
        }
    }
}