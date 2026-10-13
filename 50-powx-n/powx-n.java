class Solution {
    public double myPow(double x, int n) {
        return pow(x,n);
    }
    private double pow(double x , int n) {
        long m = n;
        double ans = 1.0;
        if(m<0) {
            // x = 1.0/x;
            m = -m;
        }
        while(m>0) {
            if(m%2 == 1) {
                ans = ans*x;
                m = m-1;
            } else {
                m = m/2;
                x = x*x;
            }
        }
        if(n < 0) ans = (1.0)/(double)(ans);
        return ans;
    }
}