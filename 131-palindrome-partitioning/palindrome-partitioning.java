class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> list = new ArrayList<>();
       List<String> temp = new ArrayList<>();
        backtrack(list,temp,s,0);
        return list;
    }
    private void backtrack(List<List<String>> list,List<String> temp,String s,int start) {
        int n = s.length();
        if(start == n) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i =start;i<n;i++) {
            String part = s.substring(start,i+1);
            if(!pallindrome(part)) {
                continue;
            }
            temp.add(part);
            backtrack(list,temp,s,i+1);
            temp.remove(temp.size()-1);
        }
    }
    private boolean pallindrome(String s) {
        int l = s.length();
        int left = 0;
        int right = l-1;
        while(left<right) {
            if(s.charAt(left) != s.charAt(right) ) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}