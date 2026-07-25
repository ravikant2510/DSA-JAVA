class Solution {
    public int maxProduct(int n) {
        int prevmax = 0;
        int currMax = 0;
        while(n>0) {
            int temp = n%10;
            if(temp>=currMax) {
                prevmax = currMax;
                currMax = temp;
            }else if(temp>prevmax) {
                prevmax = temp;
            }
            
             n = n/10;
        }
        return prevmax*currMax;

    }
}