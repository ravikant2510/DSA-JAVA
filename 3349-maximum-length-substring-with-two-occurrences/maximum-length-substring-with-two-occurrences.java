class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int[] freq = new int[26];
        while(right<s.length()) {
            freq[s.charAt(right)-'a']++;
            while(freq[s.charAt(right)-'a']>2) {
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
            maxLength=Math.max(maxLength,right-left);
        }
        return maxLength;
    }
}