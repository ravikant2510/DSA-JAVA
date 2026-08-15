class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int right = cardPoints.length-1;
        int n = cardPoints.length-k;
        // int total = 0;
        int max = 0;
        int score = 0;
        // for(int num:cardPoints) {
        //     total += num;
        // }
        int j =k;
        while(j>0) {
            score += cardPoints[right];
            right--;
            j--;
        }
        max = Math.max(max,score);
        for(int i =0;i<k;i++) {
            score += cardPoints[i];
            score -= cardPoints[n++];
           max = Math.max(max,score); 
        }
        return max;
    }
}