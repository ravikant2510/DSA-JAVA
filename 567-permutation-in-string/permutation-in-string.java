class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1length = s1.length();
        int s2length = s2.length();
        if(s1length>s2length) {
            return false;
        }
        int[] words = new int[26];
        for(int i =0;i<s1length;i++) {
           words[s1.charAt(i) - 'a']++;
           words[s2.charAt(i) - 'a']--;
        }
         if(check(words)) return true;
        for(int i = s1length;i<s2length;i++) {
            words[s2.charAt(i)-'a']--;
            words[s2.charAt(i-s1length)-'a']++;
            if(check(words)) return true;
        }
        return false;
    }


    private boolean check(int[] words) {
        for(int i = 0;i<26;i++) {
            if(words[i] != 0) {
                return false;
            }
        }
        return true;
    }
}