class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        int lowlen = String.valueOf(low).length();
        int highlen = String.valueOf(high).length();
        List<Integer> list = new ArrayList<>();
        for(int len = lowlen;len<=highlen;len++) {
            for(int i =0;i<=9-len;i++) {
                int num = Integer.parseInt(digits.substring(i,i+len));
                if(num >= low && num<= high) {
                    list.add(num);
                }
                
            }
        }
        return list;
    }
}