class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int maxLength = 0;
        int left =0;
        int k =0;
        for(int right =0;right<n;right++) {
            k += Math.abs(s.charAt(right)-t.charAt(right));
            while(k>maxCost) {
                k -= Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            if(k<=maxCost) {
                maxLength = Math.max(maxLength,right-left+1);
            }


        }
        return maxLength;
    }
}