class Solution {
    public int smallestNumber(int n, int t) {
        int q = n/10;
        int r = n%10;
        int req = t/gcd(q+(10-q)/10 ,t);
        int nxt = ((r+req-1)/req)*req;
        int x = nxt - (nxt-10)*(nxt/10);
        return q*10+x;

    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b,a%b);
    }
}